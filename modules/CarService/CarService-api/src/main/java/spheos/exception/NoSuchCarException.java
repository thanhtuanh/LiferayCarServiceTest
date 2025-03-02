/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package spheos.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchCarException extends NoSuchModelException {

	public NoSuchCarException() {
	}

	public NoSuchCarException(String msg) {
		super(msg);
	}

	public NoSuchCarException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchCarException(Throwable throwable) {
		super(throwable);
	}

}