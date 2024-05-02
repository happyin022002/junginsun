/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OpfUtilDBDAOSearchResponsiblePartyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.17
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.17 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfUtilDBDAOSearchResponsiblePartyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Responsible Party Code Search
	  * </pre>
	  */
	public OpfUtilDBDAOSearchResponsiblePartyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.opfcommon.opfutil.integration").append("\n"); 
		query.append("FileName : OpfUtilDBDAOSearchResponsiblePartyRSQL").append("\n"); 
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
		query.append("SELECT Y.XTER_CD_CTNT," ).append("\n"); 
		query.append("       Y.INTER_CD_CTNT" ).append("\n"); 
		query.append("  FROM OPF_XTER_CD_CONV_MST X ," ).append("\n"); 
		query.append("       OPF_XTER_CD_CONV_DTL Y" ).append("\n"); 
		query.append(" WHERE X.XTER_CD_KND_CTNT = Y.XTER_CD_KND_CTNT" ).append("\n"); 
		query.append("   AND X.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND Y.DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND X.XTER_CD_KND_CTNT = 'RESTOW_ACCOUNT'" ).append("\n"); 
		query.append("#if (${crr_cd} != '') " ).append("\n"); 
		query.append("   AND Y.XTER_CD_CTNT = @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}