/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : USARailWoAckManageDBDAOaddUSARailReWoAckManageListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.12
*@LastModifier : 박준용
*@LastVersion : 1.0
* 2010.01.12 박준용
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.usarailwoack.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Jun Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USARailWoAckManageDBDAOaddUSARailReWoAckManageListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_TRSP_EDI_RAIL_ORD_RSND 테이블의 CRE_OFC_CD조회
	  * </pre>
	  */
	public USARailWoAckManageDBDAOaddUSARailReWoAckManageListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_edi_ctrl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.trs.servicesio.usarailwoack.integration ").append("\n"); 
		query.append("FileName : USARailWoAckManageDBDAOaddUSARailReWoAckManageListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT		CRE_OFC_CD" ).append("\n"); 
		query.append("FROM 		TRS_TRSP_EDI_RAIL_ORD_RSND" ).append("\n"); 
		query.append("WHERE		BIL_EDI_CTRL_SEQ	 	= TO_NUMBER(@[bil_edi_ctrl_seq])" ).append("\n"); 

	}
}