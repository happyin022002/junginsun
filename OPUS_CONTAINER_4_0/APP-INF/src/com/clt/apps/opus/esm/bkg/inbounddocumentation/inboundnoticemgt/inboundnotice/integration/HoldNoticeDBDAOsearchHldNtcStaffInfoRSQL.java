/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HoldNoticeDBDAOsearchHldNtcStaffInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.20
*@LastModifier : 
*@LastVersion : 1.0
* 2010.01.20 
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

public class HoldNoticeDBDAOsearchHldNtcStaffInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Hold Mail/Alert Set-Up에서 대화주 Hold Notice 송부와 별도로 내부적으로 자동 Mail or/and Alert를 받기를 희망하는 Staff에 의해 Setting된 정보를 조회한다.
	  * </pre>
	  */
	public HoldNoticeDBDAOsearchHldNtcStaffInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cstms_hld_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : HoldNoticeDBDAOsearchHldNtcStaffInfoRSQL").append("\n"); 
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
		query.append("-- HldNtcStaffInfoVO 생성" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("	A.HLD_SEQ" ).append("\n"); 
		query.append(",	A.CSTMS_LOC_CD" ).append("\n"); 
		query.append(",	A.NTC_USR_ID" ).append("\n"); 
		query.append(",	A.CSTMS_DSPO_CD" ).append("\n"); 
		query.append(",	A.NTC_MZD_CD" ).append("\n"); 
		query.append(",	A.NTC_ENBL_FLG" ).append("\n"); 
		query.append(",	A.NTC_EML" ).append("\n"); 
		query.append(",	B.USR_NM AS NTC_USR_NM" ).append("\n"); 
		query.append("FROM BKG_HLD_NTC_USR A," ).append("\n"); 
		query.append("     COM_USER        B" ).append("\n"); 
		query.append("WHERE A.CSTMS_LOC_CD = @[cstms_loc_cd]" ).append("\n"); 
		query.append("AND	A.CSTMS_DSPO_CD IN ('*',@[cstms_hld_cd])" ).append("\n"); 
		query.append("AND	A.NTC_ENBL_FLG = 'Y'" ).append("\n"); 
		query.append("AND A.NTC_USR_ID = B.USR_ID(+)" ).append("\n"); 

	}
}