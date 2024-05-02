/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TCharterIOBunkerRegisterDAOFmsContractByBunkerUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.18
*@LastModifier : 이준범
*@LastVersion : 1.0
* 2011.05.18 이준범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jun-bum, Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TCharterIOBunkerRegisterDAOFmsContractByBunkerUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TCharterIOBunkerRegisterDAOFmsContractByBunkerUSQL
	  * 
	  * History
	  * 2011.02.14 이병훈 [CHM-201108730-01] FMS  Bunker 생성 및 수정 시에 계약 BOD/BOR 날짜 수정 보완
	  * 2011.05.18 Ticket ID : [CHM-201110910-01] 
	  * 개발자 : 이준범
	  * 제목 : Bunker Data Management 화면의 BUNKER 관련 Data가 계약에 변경되게 처리 요청
	  * 내용 : Live 에서만 오류 발생하여, 기존 유지보수[CHM-201108730-01] 시 변경된 파일 재 적용 ( 설계자 의견 )
	  * </pre>
	  */
	public TCharterIOBunkerRegisterDAOFmsContractByBunkerUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_bod_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bod_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bor_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doil_bor_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exp_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_doil_bod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("doil_bod_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("flet_ctrt_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_foil_bor_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.DECIMAL + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_foil_bod_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foil_bor_out_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("act_doil_bor_qty",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration").append("\n"); 
		query.append("FileName : TCharterIOBunkerRegisterDAOFmsContractByBunkerUSQL").append("\n"); 
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
		query.append("UPDATE FMS_CONTRACT" ).append("\n"); 
		query.append("   SET ACT_FOIL_BOD_QTY = DECODE(@[act_foil_bod_qty],NULL,ACT_FOIL_BOD_QTY,@[act_foil_bod_qty])," ).append("\n"); 
		query.append("    ACT_DOIL_BOD_QTY = DECODE(@[act_doil_bod_qty],NULL,ACT_DOIL_BOD_QTY,@[act_doil_bod_qty])," ).append("\n"); 
		query.append("    ACT_FOIL_BOR_QTY = DECODE(@[act_foil_bor_qty],NULL,ACT_FOIL_BOR_QTY,@[act_foil_bor_qty])," ).append("\n"); 
		query.append("    ACT_DOIL_BOR_QTY = DECODE(@[act_doil_bor_qty],NULL,ACT_DOIL_BOR_QTY,@[act_doil_bor_qty])," ).append("\n"); 
		query.append("    FOIL_BOD_OUT_PRC = DECODE(@[foil_bod_out_prc],NULL,FOIL_BOD_OUT_PRC,@[foil_bod_out_prc])," ).append("\n"); 
		query.append("    DOIL_BOD_OUT_PRC = DECODE(@[doil_bod_out_prc],NULL,DOIL_BOD_OUT_PRC,@[doil_bod_out_prc])," ).append("\n"); 
		query.append("    FOIL_BOR_OUT_PRC = DECODE(@[foil_bor_out_prc],NULL,FOIL_BOR_OUT_PRC,@[foil_bor_out_prc])," ).append("\n"); 
		query.append("    DOIL_BOR_OUT_PRC = DECODE(@[doil_bor_out_prc],NULL,DOIL_BOR_OUT_PRC,@[doil_bor_out_prc])," ).append("\n"); 
		query.append("       BOD_PORT_CD = DECODE(@[bod_port_cd],NULL,BOD_PORT_CD,@[bod_port_cd])," ).append("\n"); 
		query.append("       BOR_PORT_CD = DECODE(@[bor_port_cd],NULL,BOR_PORT_CD,@[bor_port_cd])," ).append("\n"); 
		query.append("       EFF_DT = CASE WHEN SUBSTR(@[flet_ctrt_no],5,2) = 'TO' THEN" ).append("\n"); 
		query.append("              DECODE(@[exp_dt],NULL,EFF_DT,TO_DATE(@[exp_dt],'yyyymmddhh24:mi'))" ).append("\n"); 
		query.append("            ELSE  " ).append("\n"); 
		query.append("               DECODE(@[eff_dt],NULL,EFF_DT,TO_DATE(@[eff_dt],'yyyymmddhh24:mi'))" ).append("\n"); 
		query.append("            END," ).append("\n"); 
		query.append("       EXP_DT = CASE WHEN SUBSTR(@[flet_ctrt_no],5,2) = 'TO' THEN" ).append("\n"); 
		query.append("                 DECODE(@[eff_dt],NULL,EXP_DT,TO_DATE(@[eff_dt],'yyyymmddhh24:mi'))  " ).append("\n"); 
		query.append("         ELSE  " ).append("\n"); 
		query.append("              DECODE(@[exp_dt],NULL,EXP_DT,TO_DATE(@[exp_dt],'yyyymmddhh24:mi'))  " ).append("\n"); 
		query.append("               END," ).append("\n"); 
		query.append("       UPD_USR_ID = @[upd_usr_id]," ).append("\n"); 
		query.append("       UPD_DT = SYSDATE" ).append("\n"); 
		query.append(" WHERE FLET_CTRT_NO = @[flet_ctrt_no]" ).append("\n"); 

	}
}