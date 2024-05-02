/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Eur24CustomsTransmissionDBDAOSearchBlCntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.05
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2015.06.05 김민정
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Minjung Kim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Eur24CustomsTransmissionDBDAOSearchBlCntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Eur24CustomsTransmissionDBDAOSearchBlCntrRSQL
	  * </pre>
	  */
	public Eur24CustomsTransmissionDBDAOSearchBlCntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration").append("\n"); 
		query.append("FileName : Eur24CustomsTransmissionDBDAOSearchBlCntrRSQL").append("\n"); 
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
		query.append("/* Eur24BlCntrListVOs Eur24CustomsTransmissionDBDAOSearchBlCntr ( String blNo , String vslCd , String skdVoyNo , String skdDirCd , String cstmsPortCd) */" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("   CNTR_NO      AS CNTRNBR  /* 99 */" ).append("\n"); 
		query.append(" , ''           AS FM_IND   /* 100 */" ).append("\n"); 
		query.append(" , NVL((SELECT CSTMS_PCK_TP_CD" ).append("\n"); 
		query.append("	   FROM BKG_CSTMS_PCK_TP_CONV" ).append("\n"); 
		query.append("	  WHERE CNT_CD ='EU'" ).append("\n"); 
		query.append("        AND RCVR_ID = 'ENS'" ).append("\n"); 
		query.append("        AND PCK_TP_CD = X.PCK_TP_CD),X.PCK_TP_CD)  AS PUNIT    /* 101 */" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" , PCK_QTY      AS PKG      /* 102 */" ).append("\n"); 
		query.append(" , ACT_WGT      AS CNTRWGT  /* 103 */" ).append("\n"); 
		query.append(" , ''           AS CNTRGWGT /* 104 */" ).append("\n"); 
		query.append(" , WGT_UT_CD    AS CNTR_WGT_UNIT /* 105 */" ).append("\n"); 
		query.append(" , CNTR_TPSZ_CD AS CNTRTYPE      /* 106 */" ).append("\n"); 
		query.append(" , BKG_SPCLCHAR_CONV_FNC(CMDT_DESC,'X')    AS CMDT_DESC     /* 107 */" ).append("\n"); 
		query.append(" , ''           AS CMDTCD        /* 108 */" ).append("\n"); 
		query.append("  ,VSL_CD,      SKD_VOY_NO,   SKD_DIR_CD,     BL_NO,       CSTMS_PORT_CD,  CNTR_NO" ).append("\n"); 
		query.append("  ,FULL_MTY_CD, PCK_QTY,      PCK_TP_CD,      MEAS_QTY,    MEAS_UT_CD,     ACT_WGT,     WGT_UT_CD,    CNTR_TPSZ_CD,    CMDT_DESC" ).append("\n"); 
		query.append("  ,CRE_USR_ID,  CRE_DT,       UPD_USR_ID,     UPD_DT" ).append("\n"); 
		query.append("FROM BKG_CSTMS_EUR_CNTR X" ).append("\n"); 
		query.append("WHERE VSL_CD   = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND BL_NO      = @[bl_no]" ).append("\n"); 
		query.append("AND CSTMS_PORT_CD = @[cstms_port_cd]" ).append("\n"); 

	}
}