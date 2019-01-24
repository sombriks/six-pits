package six.pits.game.web;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import six.pits.game.service.BaseService;

public abstract class BaseResource<T, I extends Serializable> {

  private BaseService<T, I> service;

  public BaseResource(BaseService<T, I> service) {
    this.service = service;
  }

  @GetMapping("list")
  public List<T> list(@RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer pageSize) {
    return service.list(page, pageSize);
  }

  @GetMapping("{id}")
  public T find(@PathVariable(name = "id", required = true) I id) {
    return service.find(id);
  }

  @PostMapping("save")
  public T insert(T payload) {
    return service.insert(payload);
  }

  @PutMapping("save")
  public T update(T payload) {
    return service.update(payload);
  }

  @DeleteMapping("{id}")
  public T del(@PathVariable(name = "id", required = true) I id) {
    return service.find(id);
  }

}