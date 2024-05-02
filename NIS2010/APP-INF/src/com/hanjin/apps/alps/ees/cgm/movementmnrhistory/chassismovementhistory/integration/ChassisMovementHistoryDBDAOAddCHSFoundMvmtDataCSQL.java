/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChassisMovementHistoryDBDAOAddCHSFoundMvmtDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.08
*@LastModifier : 최민회
*@LastVersion : 1.0
* 2010.01.08 최민회
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI MIN HOI
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChassisMovementHistoryDBDAOAddCHSFoundMvmtDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 장비 Lost 관련 'Found' movement 를 입력한다.    
	  * </pre>
	  */
	public ChassisMovementHistoryDBDAOAddCHSFoundMvmtDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_ownr_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("chss_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mgst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("diff_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mvmt_co_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gate_io_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.integration").append("\n"); 
		query.append("FileName : ChassisMovementHistoryDBDAOAddCHSFoundMvmtDataCSQL").append("\n"); 
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
		query.append("INSERT INTO CGM_CHSS_MVMT_HIS" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("CHSS_NO" ).append("\n"); 
		query.append(",MVMT_DT" ).append("\n"); 
		query.append(",SYS_SEQ" ).append("\n"); 
		query.append(",CHSS_OWNR_CO_CD" ).append("\n"); 
		query.append(",YD_CD" ).append("\n"); 
		query.append(",LOC_CD" ).append("\n"); 
		query.append(",SCC_CD" ).append("\n"); 
		query.append(",LCC_CD" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",CNTR_OWNR_CO_CD" ).append("\n"); 
		query.append(",DEST_YD_CD" ).append("\n"); 
		query.append(",GATE_IO_CD" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(",MVMT_STS_CD" ).append("\n"); 
		query.append(",MVMT_RSN_CD" ).append("\n"); 
		query.append(",MGST_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",MVMT_CO_CD" ).append("\n"); 
		query.append(",DIFF_RMK" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")VALUES" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("@[chss_no]" ).append("\n"); 
		query.append(",TO_DATE(@[mvmt_dt],'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append(",(SELECT DECODE(MAX(SYS_SEQ)+1,NULL,1,MAX(SYS_SEQ)+1) FROM CGM_CHSS_MVMT_HIS WHERE CHSS_NO= @[chss_no] and MVMT_DT = TO_DATE(@[mvmt_dt],'YYYY-MM-DD HH24:MI:SS') )" ).append("\n"); 
		query.append(", NVL((SELECT CASE WHEN (A.ACIAC_DIV_CD = 'A' AND A.AGMT_LSTM_CD NOT IN ('NP','CP') )" ).append("\n"); 
		query.append("OR (A.ACIAC_DIV_CD <> 'A' AND B.EQ_ASET_STS_CD = 'LST')" ).append("\n"); 
		query.append("THEN 'H'" ).append("\n"); 
		query.append("ELSE 'O'" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append("FROM CGM_EQUIPMENT A , CGM_EQ_STS_HIS B" ).append("\n"); 
		query.append("WHERE A.EQ_NO= @[chss_no]" ).append("\n"); 
		query.append("AND A.EQ_NO= B.EQ_NO" ).append("\n"); 
		query.append("AND A.EQ_STS_SEQ = B.EQ_STS_SEQ),'O')" ).append("\n"); 
		query.append(",@[yd_cd]" ).append("\n"); 
		query.append(",SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append(", (SELECT SCC_CD FROM MDM_LOCATION AA WHERE LOC_CD = SUBSTR(@[yd_cd],1,5) )" ).append("\n"); 
		query.append(", (SELECT BB.LCC_CD FROM MDM_LOCATION AA, MDM_EQ_ORZ_CHT BB" ).append("\n"); 
		query.append("WHERE AA.LOC_CD = SUBSTR(@[yd_cd],1,5)" ).append("\n"); 
		query.append("AND AA.SCC_CD = BB.SCC_CD" ).append("\n"); 
		query.append("AND ROWNUM=1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(",@[cntr_no]" ).append("\n"); 
		query.append(",@[cntr_ownr_co_cd]" ).append("\n"); 
		query.append(",@[dest_yd_cd]" ).append("\n"); 
		query.append(",@[gate_io_cd]" ).append("\n"); 
		query.append(",@[vndr_seq]" ).append("\n"); 
		query.append(",@[mvmt_sts_cd]" ).append("\n"); 
		query.append(",@[mvmt_rsn_cd]" ).append("\n"); 
		query.append(",@[mgst_no]" ).append("\n"); 
		query.append(",@[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(",@[mvmt_co_cd]" ).append("\n"); 
		query.append(",@[diff_rmk]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}