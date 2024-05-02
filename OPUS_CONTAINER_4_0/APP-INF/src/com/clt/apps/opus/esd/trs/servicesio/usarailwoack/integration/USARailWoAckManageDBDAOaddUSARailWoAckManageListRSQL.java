/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USARailWoAckManageDBDAOaddUSARailWoAckManageListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.usarailwoack.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USARailWoAckManageDBDAOaddUSARailWoAckManageListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_TRSP_EDI_RAIL_ORD 테이블의 CRE_OFC_CD조회
	  * </pre>
	  */
	public USARailWoAckManageDBDAOaddUSARailWoAckManageListRSQL(){
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
		query.append("FileName : USARailWoAckManageDBDAOaddUSARailWoAckManageListRSQL").append("\n"); 
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
		query.append("FROM 		TRS_TRSP_EDI_RAIL_ORD" ).append("\n"); 
		query.append("WHERE		BIL_EDI_CTRL_SEQ	 	= TO_NUMBER(@[bil_edi_ctrl_seq])" ).append("\n"); 

	}
}