/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package lxd.zhihu.exception;

/**
 * 自定义异常
 *
 * @author rubby
 * @create 2019/2/19
 * @since 1.0.0
 */
public class BizException extends RuntimeException {

    private String msg;
    private String code;

	public BizException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public BizException(String code, String msg) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public String getCode() {
		return code;
	}

}
