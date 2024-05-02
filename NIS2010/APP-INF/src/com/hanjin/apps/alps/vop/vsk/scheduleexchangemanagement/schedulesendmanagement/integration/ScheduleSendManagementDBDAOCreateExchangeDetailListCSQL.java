/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ScheduleSendManagementDBDAOCreateExchangeDetailListCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ScheduleSendManagementDBDAOCreateExchangeDetailListCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EDI Exchange Detail 데이터 생성
	  * </pre>
	  */
	public ScheduleSendManagementDBDAOCreateExchangeDetailListCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("co_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_edi_rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.integration").append("\n"); 
		query.append("FileName : ScheduleSendManagementDBDAOCreateExchangeDetailListCSQL").append("\n"); 
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
		query.append("INSERT INTO  VSK_VSL_SKD_XCH_EDI_DTL   D" ).append("\n"); 
		query.append("      (    D.SND_RCV_KND_CD" ).append("\n"); 
		query.append("        ,  D.SKD_EDI_RCV_DT" ).append("\n"); 
		query.append("        ,  D.SKD_EDI_RCV_SEQ" ).append("\n"); 
		query.append("        ,  D.EDI_XCH_LOG_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,  D.VSL_CD_CTNT" ).append("\n"); 
		query.append("        ,  D.SKD_VOY_NO_CTNT" ).append("\n"); 
		query.append("        ,  D.SKD_DIR_CD_CTNT        " ).append("\n"); 
		query.append("        ,  D.VPS_PORT_CD_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("		-- ::2014-04-20:: --" ).append("\n"); 
		query.append("		,  D.ALLN_PORT_CD_CTNT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,  D.VPS_PORT_NM" ).append("\n"); 
		query.append("        ,  D.YD_CD_CTNT" ).append("\n"); 
		query.append("        ,  D.CLPT_IND_SEQ_CTNT" ).append("\n"); 
		query.append("        ,  D.CLPT_SEQ_CTNT" ).append("\n"); 
		query.append("        ,  D.LOC_IND_CD_CTNT" ).append("\n"); 
		query.append("        ,  D.CALL_YD_IND_SEQ_CTNT" ).append("\n"); 
		query.append("        ,  D.VPS_ETA_DT_CTNT" ).append("\n"); 
		query.append("        ,  D.VPS_ETB_DT_CTNT" ).append("\n"); 
		query.append("        ,  D.VPS_ETD_DT_CTNT" ).append("\n"); 
		query.append("        ,  D.ACT_ARR_DT_CTNT" ).append("\n"); 
		query.append("        ,  D.ACT_BRTH_DT_CTNT" ).append("\n"); 
		query.append("        ,  D.ACT_DEP_DT_CTNT" ).append("\n"); 
		query.append("        ,  D.TURN_PORT_FLG_CTNT" ).append("\n"); 
		query.append("        ,  D.TURN_PORT_IND_CD_CTNT" ).append("\n"); 
		query.append("        ,  D.TURN_SKD_VOY_NO_CTNT" ).append("\n"); 
		query.append("        ,  D.TURN_SKD_DIR_CD_CTNT" ).append("\n"); 
		query.append("        ,  D.TURN_CLPT_IND_SEQ_CTNT" ).append("\n"); 
		query.append("        ,  D.CRE_USR_ID" ).append("\n"); 
		query.append("        ,  D.CRE_DT" ).append("\n"); 
		query.append("        ,  D.UPD_USR_ID" ).append("\n"); 
		query.append("        ,  D.UPD_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("      )" ).append("\n"); 
		query.append("SELECT    " ).append("\n"); 
		query.append("           'S'  							/*  SND_RCV_KND_CD        */" ).append("\n"); 
		query.append("        ,  TO_DATE(TO_CHAR(SYSDATE,'YYYYMMDD'),'YYYYMMDD')    	/*  SKD_EDI_RCV_DT              */" ).append("\n"); 
		query.append("        ,  @[skd_edi_rcv_seq]             	/*  SKD_EDI_RCV_SEQ             */" ).append("\n"); 
		query.append("        ,  edi_xch_log_seq.nextval        	/*  EDI_XCH_LOG_SEQ             */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,  PS.VSL_CD                     	/*  VSL_CD_CTNT                 */" ).append("\n"); 
		query.append("        ,  PS.SKD_VOY_NO                 	/*  SKD_VOY_NO_CTNT             */" ).append("\n"); 
		query.append("        ,  PS.SKD_DIR_CD                 	/*  SKD_DIR_CD_CTNT             */        " ).append("\n"); 
		query.append("        ,  PS.VPS_PORT_CD                 	/*  VPS_PORT_CD_CTNT            */" ).append("\n"); 
		query.append("		" ).append("\n"); 
		query.append("		--	::2014-04-20:: --" ).append("\n"); 
		query.append("		,	CASE	WHEN (SELECT C.ALLN_PORT_CD FROM VSK_VSL_CONV_PORT C WHERE C.ALLN_CO_CD = @[co_cd_ctnt] AND C.HJS_PORT_CD = PS.VPS_PORT_CD) IS NULL THEN PS.VPS_PORT_CD" ).append("\n"); 
		query.append("				 	ELSE (SELECT C.ALLN_PORT_CD FROM VSK_VSL_CONV_PORT C WHERE C.ALLN_CO_CD = @[co_cd_ctnt] AND C.HJS_PORT_CD = PS.VPS_PORT_CD)" ).append("\n"); 
		query.append("			END								/*  ALLN_PORT_CD_CTNT			*/	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,  ML.LOC_NM                      	/*  VPS_PORT_NM                 */" ).append("\n"); 
		query.append("        ,  PS.YD_CD                       	/*  YD_CD_CTNT                  */" ).append("\n"); 
		query.append("        ,  PS.CLPT_IND_SEQ                	/*  CLPT_IND_SEQ_CTNT           */" ).append("\n"); 
		query.append("		   -- LOC_IND ==> 9:Port of Loading, 153:Port of Call (CLPT_SEQ:1), 11:Port of Discharge --" ).append("\n"); 
		query.append("        ,  '1'                    			/*  CLPT_SEQ_CTNT               */" ).append("\n"); 
		query.append("        ,  '153'  							/*  LOC_IND_CD_CTNT             */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        ,  PS.CALL_YD_IND_SEQ             	/*  CALL_YD_IND_SEQ_CTNT        */" ).append("\n"); 
		query.append("        ,  TO_CHAR(PS.VPS_ETA_DT ,'YYYYMMDDHH24MI')  /*  VPS_ETA_DT_CTNT             */" ).append("\n"); 
		query.append("        ,  TO_CHAR(PS.VPS_ETB_DT ,'YYYYMMDDHH24MI')  /*  VPS_ETB_DT_CTNT             */" ).append("\n"); 
		query.append("        ,  TO_CHAR(PS.VPS_ETD_DT ,'YYYYMMDDHH24MI')  /*  VPS_ETD_DT_CTNT             */" ).append("\n"); 
		query.append("        ,  TO_CHAR(AK.ACT_ARR_DT ,'YYYYMMDDHH24MI')  /*  ACT_ARR_DT_CTNT             */" ).append("\n"); 
		query.append("        ,  TO_CHAR(AK.ACT_BRTH_DT,'YYYYMMDDHH24MI')  /*  ACT_BRTH_DT_CTNT            */" ).append("\n"); 
		query.append("        ,  TO_CHAR(AK.ACT_DEP_DT ,'YYYYMMDDHH24MI')  /*  ACT_DEP_DT_CTNT             */" ).append("\n"); 
		query.append("        ,  PS.TURN_PORT_FLG              	/*  TURN_PORT_FLG_CTNT          */" ).append("\n"); 
		query.append("        ,  PS.TURN_PORT_IND_CD           	/*  TURN_PORT_IND_CD_CTNT       */" ).append("\n"); 
		query.append("        ,  PS.TURN_SKD_VOY_NO            	/*  TURN_SKD_VOY_NO_CTNT        */" ).append("\n"); 
		query.append("        ,  PS.TURN_SKD_DIR_CD            	/*  TURN_SKD_DIR_CD_CTNT        */" ).append("\n"); 
		query.append("        ,  PS.TURN_CLPT_IND_SEQ          	/*  TURN_CLPT_IND_SEQ_CTNT      */" ).append("\n"); 
		query.append("        ,  @[cre_usr_id]                 	/*  CRE_USR_ID                  */" ).append("\n"); 
		query.append("        ,  SYSDATE                       	/*  CRE_DT                      */" ).append("\n"); 
		query.append("        ,  @[upd_usr_id]                 	/*  UPD_USR_ID                  */" ).append("\n"); 
		query.append("        ,  SYSDATE                       	/*  UPD_DT                      */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM       VSK_VSL_PORT_SKD                    PS" ).append("\n"); 
		query.append("        ,  MDM_VSL_CNTR                        VC" ).append("\n"); 
		query.append("        ,  MDM_LOCATION                        ML" ).append("\n"); 
		query.append("        ,  VSK_ACT_PORT_SKD                    AK" ).append("\n"); 
		query.append("WHERE      1 = 1" ).append("\n"); 
		query.append("AND        PS.VSL_CD                           = VC.VSL_CD" ).append("\n"); 
		query.append("AND        PS.VPS_PORT_CD                      = ML.LOC_CD" ).append("\n"); 
		query.append("AND        PS.VSL_CD                           = AK.VSL_CD           (+)" ).append("\n"); 
		query.append("AND        PS.SKD_VOY_NO                       = AK.SKD_VOY_NO       (+)" ).append("\n"); 
		query.append("AND        PS.SKD_DIR_CD                       = AK.SKD_DIR_CD       (+)" ).append("\n"); 
		query.append("AND        PS.VPS_PORT_CD                      = AK.VPS_PORT_CD      (+)" ).append("\n"); 
		query.append("AND        PS.CLPT_IND_SEQ                     = AK.CLPT_IND_SEQ     (+)" ).append("\n"); 
		query.append("AND        PS.VSL_CD                           = @[vsl_cd_ctnt]" ).append("\n"); 
		query.append("AND        PS.SKD_VOY_NO                       = @[skd_voy_no_ctnt]" ).append("\n"); 
		query.append("AND        PS.SKD_DIR_CD                       = @[skd_dir_cd_ctnt]" ).append("\n"); 

	}
}