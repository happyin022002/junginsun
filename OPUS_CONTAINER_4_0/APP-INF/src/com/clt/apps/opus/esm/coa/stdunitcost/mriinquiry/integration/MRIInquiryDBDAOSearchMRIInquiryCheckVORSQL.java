/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : MRIInquiryDBDAOSearchMRIInquiryCheckVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.28
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2011.02.28 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author SHOISUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MRIInquiryDBDAOSearchMRIInquiryCheckVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * lane 코드 체크
	  * </pre>
	  */
	public MRIInquiryDBDAOSearchMRIInquiryCheckVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.integration ").append("\n"); 
		query.append("FileName : MRIInquiryDBDAOSearchMRIInquiryCheckVORSQL").append("\n"); 
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
		query.append("SELECT RLANE_CD NAME" ).append("\n"); 
		query.append("	  ,RLANE_CD CODE " ).append("\n"); 
		query.append("  FROM COA_LANE_RGST " ).append("\n"); 
		query.append(" WHERE NVL(DELT_FLG,'N') = 'N' " ).append("\n"); 
		query.append("   AND TRD_CD 	= @[trd_cd]" ).append("\n"); 
		query.append("   AND RLANE_CD = @[rlane_cd]" ).append("\n"); 

	}
}