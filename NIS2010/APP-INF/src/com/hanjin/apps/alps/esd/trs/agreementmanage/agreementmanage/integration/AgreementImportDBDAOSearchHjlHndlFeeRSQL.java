/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgreementImportDBDAOSearchHjlHndlFeeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.14
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2012.06.14 신동일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHIN DONG IL
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AgreementImportDBDAOSearchHjlHndlFeeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2012.05.23 SHIN DONG IL [] HJL HANDLING FEE SEARCH
	  * </pre>
	  */
	public AgreementImportDBDAOSearchHjlHndlFeeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration").append("\n"); 
		query.append("FileName : AgreementImportDBDAOSearchHjlHndlFeeRSQL").append("\n"); 
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
		query.append("SELECT A.HJL_OFC_CD" ).append("\n"); 
		query.append(",9999 HNDL_FEE_HIS_SEQ" ).append("\n"); 
		query.append(",A.VNDR_SEQ" ).append("\n"); 
		query.append(",A.CURR_CD" ).append("\n"); 
		query.append(",A.COST_RCVR_AMT" ).append("\n"); 
		query.append(",A.COMM_AMT" ).append("\n"); 
		query.append(",A.TTL_AMT" ).append("\n"); 
		query.append(",TO_CHAR(TO_DATE(A.EFF_FM_DT),'YYYY-MM-DD') EFF_FM_DT" ).append("\n"); 
		query.append(",'29991231' EFF_TO_DT" ).append("\n"); 
		query.append(",A.CURR_CD ORG_CURR_CD" ).append("\n"); 
		query.append(",A.COST_RCVR_AMT ORG_COST_RCVR_AMT" ).append("\n"); 
		query.append(",A.COMM_AMT ORG_COMM_AMT" ).append("\n"); 
		query.append(",A.TTL_AMT ORG_TTL_AMT" ).append("\n"); 
		query.append(",TO_CHAR(TO_DATE(A.EFF_FM_DT),'YYYYMMDD') ORG_EFF_FM_DT" ).append("\n"); 
		query.append(",A.CRE_USR_ID" ).append("\n"); 
		query.append(",( SELECT USR_NM" ).append("\n"); 
		query.append("FROM COM_USER" ).append("\n"); 
		query.append("WHERE USR_ID = A.CRE_USR_ID	) CRE_USR_NM" ).append("\n"); 
		query.append(",TO_CHAR(A.CRE_DT,'YYYY-MM-DD HH24:MI:SS') CRE_DT" ).append("\n"); 
		query.append(",A.UPD_USR_ID" ).append("\n"); 
		query.append(",( SELECT USR_NM" ).append("\n"); 
		query.append("FROM COM_USER" ).append("\n"); 
		query.append("WHERE USR_ID = A.UPD_USR_ID	) UPD_USR_NM" ).append("\n"); 
		query.append(",TO_CHAR(A.UPD_DT,'YYYY-MM-DD HH24:MI:SS') UPD_DT" ).append("\n"); 
		query.append("FROM TRS_HJL_HNDL_FEE A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if ($ofc_cd.size() > 0)" ).append("\n"); 
		query.append("AND A.HJL_OFC_CD in (" ).append("\n"); 
		query.append("#foreach( ${key} in ${ofc_cd})" ).append("\n"); 
		query.append("#if($velocityCount < $ofc_cd.size())" ).append("\n"); 
		query.append("'$key'," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("'$key'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${fm_dt} != '')" ).append("\n"); 
		query.append("AND TO_DATE(@[fm_dt],'YYYYMMDD') BETWEEN  A.EFF_FM_DT AND TO_DATE('29991231','YYYYMMDD')" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}