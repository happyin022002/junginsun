/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WebGateDBDAOInsertMovementCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.03
*@LastModifier : 윤권영
*@LastVersion : 1.0
* 2011.08.03 윤권영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.servicesio.newwebgate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author yun kwon-young
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class WebGateDBDAOInsertMovementCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Container Movement 상태를 업데이트 한다.
	  * </pre>
	  */
	public WebGateDBDAOInsertMovementCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("office",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("act_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("nod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.servicesio.newwebgate.integration").append("\n"); 
		query.append("FileName : WebGateDBDAOInsertMovementCSQL").append("\n"); 
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
		query.append("INSERT ALL" ).append("\n"); 
		query.append("INTO SCE_ACT_RCV_IF (" ).append("\n"); 
		query.append("ACT_RCV_DT" ).append("\n"); 
		query.append(",ACT_RCV_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",ACT_DT" ).append("\n"); 
		query.append(",ACT_STS_MAPG_CD" ).append("\n"); 
		query.append(",NOD_CD" ).append("\n"); 
		query.append(",ACT_RCV_TP_CD" ).append("\n"); 
		query.append(",ACT_UMCH_TP_CD" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(",ACT_GDT" ).append("\n"); 
		query.append(",ACT_DAT_RCV_DT" ).append("\n"); 
		query.append(",VNDR_NM" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append(",SCE_ACT_RCV_IF_SEQ1.NEXTVAL" ).append("\n"); 
		query.append(",@[bkg_no]" ).append("\n"); 
		query.append(",@[cntr_no]" ).append("\n"); 
		query.append(",TO_DATE(@[act_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",@[act_cd]" ).append("\n"); 
		query.append(",@[nod_cd]" ).append("\n"); 
		query.append(",'9'" ).append("\n"); 
		query.append(",'00'" ).append("\n"); 
		query.append(",@[vndr_seq]" ).append("\n"); 
		query.append(",NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[office]),SYSDATE)" ).append("\n"); 
		query.append(",NVL((SELECT GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,LOC_CD)FROM MDM_VENDOR WHERE VNDR_SEQ = @[vndr_seq]), SYSDATE)" ).append("\n"); 
		query.append(",@[user_id]||'(e-Tracker)'" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("INTO SCE_SVC_PTAL_ACT_IF (" ).append("\n"); 
		query.append("ACT_RCV_DT" ).append("\n"); 
		query.append(",ACT_RCV_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",ACT_DT" ).append("\n"); 
		query.append(",ACT_STS_MAPG_CD" ).append("\n"); 
		query.append(",NOD_CD" ).append("\n"); 
		query.append(",ACT_RCV_TP_CD" ).append("\n"); 
		query.append(",ACT_UMCH_TP_CD" ).append("\n"); 
		query.append(",VNDR_SEQ" ).append("\n"); 
		query.append(",ACT_GDT" ).append("\n"); 
		query.append(",ACT_DAT_RCV_DT" ).append("\n"); 
		query.append(",VNDR_NM" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("TO_CHAR(SYSDATE, 'YYYYMMDD')" ).append("\n"); 
		query.append(",SCE_SVC_PTAL_ACT_IF_SEQ1.NEXTVAL" ).append("\n"); 
		query.append(",@[bkg_no]" ).append("\n"); 
		query.append(",@[cntr_no]" ).append("\n"); 
		query.append(",TO_DATE(@[act_dt],'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append(",@[act_cd]" ).append("\n"); 
		query.append(",@[nod_cd]" ).append("\n"); 
		query.append(",'9'" ).append("\n"); 
		query.append(",'00'" ).append("\n"); 
		query.append(",@[vndr_seq]" ).append("\n"); 
		query.append(",NVL(GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[office]),SYSDATE)" ).append("\n"); 
		query.append(",NVL((SELECT GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',SYSDATE,LOC_CD)FROM MDM_VENDOR WHERE VNDR_SEQ = @[vndr_seq]), SYSDATE)" ).append("\n"); 
		query.append(",@[user_id]||'(e-Tracker)'" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[user_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT * FROM DUAL" ).append("\n"); 

	}
}