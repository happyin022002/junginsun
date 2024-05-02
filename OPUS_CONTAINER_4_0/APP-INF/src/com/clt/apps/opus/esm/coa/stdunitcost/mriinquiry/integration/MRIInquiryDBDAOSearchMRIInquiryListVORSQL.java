/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MRIInquiryDBDAOSearchMRIInquiryListVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.11.13 장영석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Yeong-seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MRIInquiryDBDAOSearchMRIInquiryListVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * _MON_MISC_REV_PRE_TEU 테이블의 데이터 조회
	  * </pre>
	  */
	public MRIInquiryDBDAOSearchMRIInquiryListVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.stdunitcost.mriinquiry.integration").append("\n"); 
		query.append("FileName : MRIInquiryDBDAOSearchMRIInquiryListVORSQL").append("\n"); 
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
		query.append("SELECT  REV_YRMON" ).append("\n"); 
		query.append(",TRD_CD" ).append("\n"); 
		query.append(",DIR_CD" ).append("\n"); 
		query.append(",RLANE_CD" ).append("\n"); 
		query.append(",TRD_TTL_AMT" ).append("\n"); 
		query.append(",TRD_TTL_QTY" ).append("\n"); 
		query.append(",ETC_UT_REV_AMT" ).append("\n"); 
		query.append("FROM   COA_MON_MISC_REV_PRE_TEU" ).append("\n"); 
		query.append("WHERE   REV_YRMON = @[f_rev_yrmon]" ).append("\n"); 
		query.append("#if   (${istrade} == 'YES')" ).append("\n"); 
		query.append("AND  RLANE_CD  = 'XXXXX'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND  RLANE_CD  <> 'XXXXX'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if  (${f_trd_cd} != '')" ).append("\n"); 
		query.append("AND  TRD_CD   = @[f_trd_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if  (${f_rlane_cd} != '')" ).append("\n"); 
		query.append("AND  RLANE_CD = @[f_rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if  (${f_dir_cd} != '')" ).append("\n"); 
		query.append("AND  DIR_CD   = @[f_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}