/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HoldNoticeDBDAOCheckHldNtcUsrDupRSQL.java
*@FileTitle : Pick up Notice Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HoldNoticeDBDAOCheckHldNtcUsrDupRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 기 등록된 데이타 체크한다
	  * </pre>
	  */
	public HoldNoticeDBDAOCheckHldNtcUsrDupRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ntc_mzd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hld_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_dspo_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT" ).append("\n"); 
		query.append("HLD_SEQ" ).append("\n"); 
		query.append("FROM BKG_HLD_NTC_USR" ).append("\n"); 
		query.append("WHERE	CSTMS_LOC_CD = @[cstms_loc_cd]" ).append("\n"); 
		query.append("AND	   NTC_USR_ID    = @[ntc_usr_id]" ).append("\n"); 
		query.append("AND	   NTC_ENBL_FLG  = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${cstms_dspo_cd} != '*')" ).append("\n"); 
		query.append("AND	   CSTMS_DSPO_CD IN ('*',@[cstms_dspo_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${ntc_mzd_cd} != 'M')" ).append("\n"); 
		query.append("AND	   NTC_MZD_CD    IN ('M',@[ntc_mzd_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${hld_seq} != '')" ).append("\n"); 
		query.append("AND    HLD_SEQ != @[hld_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : HoldNoticeDBDAOCheckHldNtcUsrDupRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}