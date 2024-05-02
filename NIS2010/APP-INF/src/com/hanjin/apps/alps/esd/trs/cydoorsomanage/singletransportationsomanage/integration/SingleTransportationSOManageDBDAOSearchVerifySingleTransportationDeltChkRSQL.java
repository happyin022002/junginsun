/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SingleTransportationSOManageDBDAOSearchVerifySingleTransportationDeltChkRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.23
*@LastModifier : DONG- IL, SHIN
*@LastVersion : 1.0
* 2014.04.23 DONG- IL, SHIN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DONG- IL, SHIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SingleTransportationSOManageDBDAOSearchVerifySingleTransportationDeltChkRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * S/O Correction 시 Delete flag 체크로직
	  * S/O 상태 RETURN
	  * </pre>
	  */
	public SingleTransportationSOManageDBDAOSearchVerifySingleTransportationDeltChkRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.integration").append("\n"); 
		query.append("FileName : SingleTransportationSOManageDBDAOSearchVerifySingleTransportationDeltChkRSQL").append("\n"); 
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
		query.append("SELECT DELT_FLG" ).append("\n"); 
		query.append("      ,CASE WHEN TRSP_SO_STS_CD = 'C' THEN 'T'" ).append("\n"); 
		query.append("            WHEN TRSP_SO_STS_CD = 'R' THEN 'T'" ).append("\n"); 
		query.append("            ELSE 'F'" ).append("\n"); 
		query.append("       END AS SO_STS_CD" ).append("\n"); 
		query.append("  FROM TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append(" WHERE TRSP_SO_OFC_CTY_CD = @[trsp_so_ofc_cty_cd]" ).append("\n"); 
		query.append("   AND TRSP_SO_SEQ = @[trsp_so_seq]" ).append("\n"); 

	}
}