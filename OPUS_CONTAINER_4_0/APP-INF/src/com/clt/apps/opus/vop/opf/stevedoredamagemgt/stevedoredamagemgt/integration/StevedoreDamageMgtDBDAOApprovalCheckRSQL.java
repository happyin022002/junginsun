/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAOApprovalCheckRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.10.11 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class StevedoreDamageMgtDBDAOApprovalCheckRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Approval Check SQL
	  * </pre>
	  */
	public StevedoreDamageMgtDBDAOApprovalCheckRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration").append("\n"); 
		query.append("FileName : StevedoreDamageMgtDBDAOApprovalCheckRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) AS CNT " ).append("\n"); 
		query.append("FROM   COM_USER" ).append("\n"); 
		query.append("WHERE  1=1" ).append("\n"); 
		query.append("AND    OFC_CD IN " ).append("\n"); 
		query.append("	   ( " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		SELECT   MO.OFC_CD" ).append("\n"); 
		query.append("		FROM     MDM_ORGANIZATION MO" ).append("\n"); 
		query.append("		WHERE    MO.OFC_KND_CD    = '2'" ).append("\n"); 
		query.append("		AND      MO.OFC_TP_CD     = 'HQ'" ).append("\n"); 
		query.append("		AND      MO.DELT_FLG      = 'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	     --SELECT OFC_CD " ).append("\n"); 
		query.append("	     --FROM TABLE( COM_OfficeCodeMgr_PKG.COM_getOfficeCodeList_FNC( '000001', 'OPF'))" ).append("\n"); 
		query.append("	   )" ).append("\n"); 
		query.append("AND    PSN_ENG_NM = 'Team Executive'" ).append("\n"); 
		query.append("AND    USR_ID     = @[usr_id]" ).append("\n"); 

	}
}