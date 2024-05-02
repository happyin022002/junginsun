/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationDBDAOGetDualTypeExceptionCustInfoBySCRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.07.03 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi Sung Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DMTCalculationDBDAOGetDualTypeExceptionCustInfoBySCRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * getDualTypeExceptionCustInfoBySC
	  * </pre>
	  */
	public DMTCalculationDBDAOGetDualTypeExceptionCustInfoBySCRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT /*+ INDEX_DESC( PSM XPKPRI_RP_SCP_MN ) */" ).append("\n"); 
		query.append("CUST_CNT_CD" ).append("\n"); 
		query.append(",CUST_SEQ" ).append("\n"); 
		query.append("FROM PRI_SP_MN PSM" ).append("\n"); 
		query.append(",PRI_SP_CTRT_PTY SCP" ).append("\n"); 
		query.append(",PRI_SP_HDR PSH" ).append("\n"); 
		query.append("WHERE PSM.PROP_NO = PSH.PROP_NO" ).append("\n"); 
		query.append("AND PSH.SC_NO = @[sc_no]" ).append("\n"); 
		query.append("AND PSM.PROP_NO = SCP.PROP_NO" ).append("\n"); 
		query.append("AND PSM.AMDT_SEQ = SCP.AMDT_SEQ" ).append("\n"); 
		query.append("AND SCP.PRC_CTRT_PTY_TP_CD = 'C'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.ees.dmt.dmtcommonutil.dmtcalculationutil.integration ").append("\n"); 
		query.append("FileName : DMTCalculationDBDAOGetDualTypeExceptionCustInfoBySCRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}