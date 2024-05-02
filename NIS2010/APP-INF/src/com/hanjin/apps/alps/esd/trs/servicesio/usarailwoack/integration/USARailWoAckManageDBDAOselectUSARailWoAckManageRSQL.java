/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : USARailWoAckManageDBDAOselectUSARailWoAckManageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.usarailwoack.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class USARailWoAckManageDBDAOselectUSARailWoAckManageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TRS_TRSP_EDI_RAIL_ORD 와 TRS_TRSP_RAIL_BIL_ORD 테이블 조인한 데이타
	  * </pre>
	  */
	public USARailWoAckManageDBDAOselectUSARailWoAckManageRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esd.trs.servicesio.usarailwoack.integration ").append("\n"); 
		query.append("FileName : USARailWoAckManageDBDAOselectUSARailWoAckManageRSQL").append("\n"); 
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
		query.append("SELECT B.TRSP_RAIL_BIL_TP_CD" ).append("\n"); 
		query.append(", A.TRSP_SO_SEQ" ).append("\n"); 
		query.append(", A.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("FROM TRS_TRSP_EDI_RAIL_ORD A, TRS_TRSP_RAIL_BIL_ORD B" ).append("\n"); 
		query.append("WHERE A.TRSP_SO_SEQ = B.TRSP_SO_SEQ" ).append("\n"); 
		query.append("AND   A.TRSP_SO_OFC_CTY_CD = B.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND   A.BIL_EDI_CTRL_SEQ = TO_NUMBER(@[bil_edi_ctrl_seq])" ).append("\n"); 

	}
}