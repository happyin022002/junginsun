package com.hanjin.syscommon.common.menu;

/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ProgramBean.java
*@FileTitle : ?”„ë¡œê·¸?¨ Value Object
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-08-11 SeongWook Kim
* 1.0 ìµœì´ˆ ?ƒ?„±
=========================================================*/

/**
 * Program Information Bean<br>
 * Program Information?„ ?‹´?Š” ê°ì²´<br>
 * @author SeongWook Kim
 * @see 
 * @since J2EE 1.4
 */
public class ProgramBean  {
	/**
	 * ?”„ë¡œê·¸?¨ ì½”ë“œ
	 */
	private String prog_id;
	/**
	 * ?”„ë¡œê·¸?¨ ?œ ?˜•
	 */
	private String prog_kind;
	/**
	 * ?”„ë¡œê·¸?¨ëª?
	 */
	private String prog_name;
	/**
	 * ?”„ë¡œê·¸?¨ ?ƒ?„¸?„¤ëª?
	 */
	private String prog_desc;
	/**
	 * ?”„ë¡œê·¸?¨ ë§í¬ URL
	 */
	private String prog_link;
	/**
	 * ?”„ë¡œê·¸?¨ ?ƒ?ƒœ? •ë³?
	 */
	private String prog_status;
	/**
	 * ?”„ë¡œê·¸?¨ ? •ë³? ?ƒ?„±?¼
	 */
	private String prog_create_date;
	/**
	 * ?”„ë¡œê·¸?¨ ? •ë³? ?ƒ?„± ?‚¬?š©? ?•„?´?””
	 */
	private String prog_create_userid;
	/**
	 * ?”„ë¡œê·¸?¨ ? •ë³? ?—…?°?´?Š¸?¼
	 */
	private String prog_update_date;
	/**
	 * ?”„ë¡œê·¸?¨ ? •ë³? ?—…?°?´?Š¸ ?‚¬?š©? ?•„?´?””
	 */
	private String prog_update_userid;
	/**
	 * ?”„ë¡œê·¸?¨ ???„?•„?›ƒ ë¦¬ë°‹?Š¸
	 */
	private String prog_timeout;
	/**
	 * ?”„ë¡œê·¸?¨ ?Œ?—…?–´ë¶?
	 */
	private String popup_yn;
	/**
	 * ?”„ë¡œê·¸?¨ ?Š¸?œ?­?„  ?—¬ë¶?
	 */
	private String prog_transaction_yn;

	/**
	 * Bean ?ƒ?„±?
	 */
	public ProgramBean() {}

	/**
	 * Bean ?ƒ?„±?
	 * @param prog_id
	 * @param prog_kind
	 * @param prog_name
	 * @param prog_desc
	 * @param prog_link
	 * @param prog_status
	 * @param prog_create_date
	 * @param prog_create_userid
	 * @param prog_update_date
	 * @param prog_update_userid
	 * @param prog_timeout
	 * @param popup_yn
	 * @param prog_transaction_yn
	 */
	public ProgramBean(
		String prog_id,
		String prog_kind,
		String prog_name,
		String prog_desc,
		String prog_link,
		String prog_status,
		String prog_create_date,
		String prog_create_userid,
		String prog_update_date,
		String prog_update_userid,
		String prog_timeout,
		String popup_yn,
		String prog_transaction_yn ) {
		this.prog_id = prog_id;
		this.prog_kind = prog_kind;
		this.prog_name = prog_name;
		this.prog_desc = prog_desc;
		this.prog_link = prog_link;
		this.prog_status = prog_status;
		this.prog_create_date = prog_create_date;
		this.prog_create_userid = prog_create_userid;
		this.prog_update_date = prog_update_date;
		this.prog_update_userid = prog_update_userid;
		this.prog_timeout = prog_timeout;
		this.popup_yn = popup_yn;
		this.prog_transaction_yn = prog_transaction_yn;
	}

	/**
	 * @return  Returns the prog_id.
	 */
	public String getProg_id() {
		return prog_id;
	}

	/**
	 * @return  Returns the prog_kind.
	 */
	public String getProg_kind() {
		return prog_kind;
	}

	/**
	 * @return  Returns the prog_name.
	 */
	public String getProg_name() {
		return prog_name;
	}

	/**
	 * @return  Returns the prog_desc.
	 */
	public String getProg_desc() {
		return prog_desc;
	}

	/**
	 * @return  Returns the prog_link.
	 */
	public String getProg_link() {
		return prog_link;
	}

	/**
	 * @return  Returns the prog_status.
	 */
	public String getProg_status() {
		return prog_status;
	}

	/**
	 * @return  Returns the prog_create_date.
	 */
	public String getProg_create_date() {
		return prog_create_date;
	}

	/**
	 * @return  Returns the prog_create_userid.
	 */
	public String getProg_create_userid() {
		return prog_create_userid;
	}

	/**
	 * @return  Returns the prog_update_date.
	 */
	public String getProg_update_date() {
		return prog_update_date;
	}

	/**
	 * @return  Returns the prog_update_userid.
	 */
	public String getProg_update_userid() {
		return prog_update_userid;
	}

	/**
	 * @return  Returns the prog_timeout.
	 */
	public String getProg_timeout() {
		return prog_timeout;
	}

	/**
	 * @return  Returns the popup_yn.
	 */
	public String getPopup_yn() {
		return popup_yn;
	}

	/**
	 * @return  Returns the prog_transaction_yn.
	 */
	public String getProg_transaction_yn() {
		return prog_transaction_yn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("{");
		strBuf.append("prog_id             = " + prog_id).append(", ");
		strBuf.append("prog_kind           = " + prog_kind).append(", ");
		strBuf.append("prog_name           = " + prog_name).append(", ");
		strBuf.append("prog_desc           = " + prog_desc).append(", ");
		strBuf.append("prog_link           = " + prog_link).append(", ");
		strBuf.append("prog_status         = " + prog_status).append(", ");
		strBuf.append("prog_create_date    = " + prog_create_date).append(", ");
		strBuf.append("prog_create_userid  = " + prog_create_userid).append(", ");
		strBuf.append("prog_update_date    = " + prog_update_date).append(", ");
		strBuf.append("prog_update_userid  = " + prog_update_userid).append(", ");
		strBuf.append("prog_timeout        = " + prog_timeout).append(", ");
		strBuf.append("popup_yn            = " + popup_yn).append(", ");
		strBuf.append("prog_transaction_yn = " + prog_transaction_yn).append(", ");

		return strBuf.toString();
	}
}
