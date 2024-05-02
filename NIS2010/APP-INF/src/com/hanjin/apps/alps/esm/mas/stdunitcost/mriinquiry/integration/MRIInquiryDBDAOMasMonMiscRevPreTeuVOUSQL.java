/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MRIInquiryDBDAOMasMonMiscRevPreTeuVOUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 장영석
*@LastVersion : 1.0
* 2009.11.05 장영석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.mriinquiry.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Yeong-seok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MRIInquiryDBDAOMasMonMiscRevPreTeuVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * _MON_MISC_REV_PRE_TEU 테이블의 데이터 업데이트
	  * </pre>
	  */
	public MRIInquiryDBDAOMasMonMiscRevPreTeuVOUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_ttl_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("etc_ut_rev_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_ttl_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.stdunitcost.mriinquiry.integration").append("\n"); 
		query.append("FileName : MRIInquiryDBDAOMasMonMiscRevPreTeuVOUSQL").append("\n"); 
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
		query.append("UPDATE MAS_MON_MISC_REV_PRE_TEU" ).append("\n"); 
		query.append("SET TRD_TTL_AMT    = @[trd_ttl_amt]" ).append("\n"); 
		query.append(",TRD_TTL_QTY    = @[trd_ttl_qty]" ).append("\n"); 
		query.append(",ETC_UT_REV_AMT = @[etc_ut_rev_amt]" ).append("\n"); 
		query.append(",UPD_USR_ID     = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT         = SYSDATE" ).append("\n"); 
		query.append("WHERE REV_YRMON = @[rev_yrmon]" ).append("\n"); 
		query.append("AND TRD_CD    = @[trd_cd]" ).append("\n"); 
		query.append("#if (${istrade}=='YES')" ).append("\n"); 
		query.append("AND RLANE_CD  = 'XXXXX'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND RLANE_CD  <> 'XXXXX'" ).append("\n"); 
		query.append("AND RLANE_CD  = @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND DIR_CD    = @[dir_cd]" ).append("\n"); 

	}
}