/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DwellNotificationDBDAOModifyCandidateDwllNtfcSvcListDtlUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.dwellnotification.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DwellNotificationDBDAOModifyCandidateDwllNtfcSvcListDtlUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCandidateDwllNtfcSvcListDtl
	  * </pre>
	  */
	public DwellNotificationDBDAOModifyCandidateDwllNtfcSvcListDtlUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntfc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibflag",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("subsc_rmk",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.dwellnotification.integration ").append("\n"); 
		query.append("FileName : DwellNotificationDBDAOModifyCandidateDwllNtfcSvcListDtlUSQL").append("\n"); 
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
		query.append("UPDATE SCE_DWLL_CUST_SVC_LIST" ).append("\n"); 
		query.append("SET DELT_FLG    = DECODE(@[ibflag], 'D', 'Y', 'N')" ).append("\n"); 
		query.append("  , DELT_USR_ID = DECODE(@[ibflag], 'D', @[usr_id], NULL)" ).append("\n"); 
		query.append("  , SUBSC_RMK   = @[subsc_rmk]" ).append("\n"); 
		query.append("  , DELT_DT     = DECODE(@[ibflag], 'D', SYSDATE, NULL)" ).append("\n"); 
		query.append("  , UPD_USR_ID  = @[usr_id]" ).append("\n"); 
		query.append("  , UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("  AND DWLL_CUST_CNT_CD = SUBSTR(@[cust_cd],1,2)" ).append("\n"); 
		query.append("  AND DWLL_CUST_SEQ = TO_NUMBER(SUBSTR(@[cust_cd],3,6))" ).append("\n"); 
		query.append("  AND NTFC_SEQ  = @[ntfc_seq]" ).append("\n"); 

	}
}