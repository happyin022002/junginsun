/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IndiaCustomsTransmissionDBDAOsearchTPRequestEDIRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaCustomsTransmissionDBDAOsearchTPRequestEDIRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * container list대상 조회하는 오퍼레이션
	  * </pre>
	  */
	public IndiaCustomsTransmissionDBDAOsearchTPRequestEDIRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tp_fee",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.integration").append("\n"); 
		query.append("FileName : IndiaCustomsTransmissionDBDAOsearchTPRequestEDIRSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("    BCIV.IDA_AGN_ID" ).append("\n"); 
		query.append("    ,BCIV.IDA_DECL_VSL_NO" ).append("\n"); 
		query.append("    ,BCIV.VSL_DECL_DT" ).append("\n"); 
		query.append("    ,BCIV.IDA_LINE_NO " ).append("\n"); 
		query.append("    ,'0' TMP0  " ).append("\n"); 
		query.append("    ,BCIV.OTR_DCHG_YD_ID OTR_DCHG_CD" ).append("\n"); 
		query.append("    ,BCIB.IDA_TRSP_CD" ).append("\n"); 
		query.append("    ,BC.PCK_QTY" ).append("\n"); 
		query.append("    ,BC.CNTR_WGT" ).append("\n"); 
		query.append("    ,BC.WGT_UT_CD" ).append("\n"); 
		query.append("    ,'' TMP1" ).append("\n"); 
		query.append("    ,'' TMP2" ).append("\n"); 
		query.append("    ,'' TMP3" ).append("\n"); 
		query.append("    ,'' TMP4" ).append("\n"); 
		query.append("    ,'' TMP5" ).append("\n"); 
		query.append("    ,BCIV.IBD_NO" ).append("\n"); 
		query.append("    ,@[tp_fee] TP_FEE" ).append("\n"); 
		query.append("    ,BCIV.TRNS_OPR_ID AS CRR_AGN_CD" ).append("\n"); 
		query.append("FROM    " ).append("\n"); 
		query.append("        BKG_CSTMS_IDA_VSL BCIV        " ).append("\n"); 
		query.append("        ,BKG_CSTMS_IDA_BL BCIB       " ).append("\n"); 
		query.append("        ,BKG_CSTMS_IDA_CNTR BCIC    " ).append("\n"); 
		query.append("        ,BKG_CONTAINER  BC      " ).append("\n"); 
		query.append("        ,BKG_BOOKING  BB        " ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     BCIV.VSL_CD                   = BCIC.VSL_CD" ).append("\n"); 
		query.append("AND     BCIV.SKD_VOY_NO               = BCIC.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     BCIV.SKD_DIR_CD               = BCIC.SKD_DIR_CD" ).append("\n"); 
		query.append("AND     BCIV.POD_CD                   =   BCIC.POD_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     BCIC.CNTR_NO                  =   BC.CNTR_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     BCIC.BL_NO                 	  =   BB.BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     BCIC.VSL_CD                   = BCIB.VSL_CD" ).append("\n"); 
		query.append("AND     BCIC.SKD_VOY_NO               = BCIB.SKD_VOY_NO" ).append("\n"); 
		query.append("AND     BCIC.SKD_DIR_CD               = BCIB.SKD_DIR_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     BCIC.POD_CD                	  =   BCIB.POD_CD" ).append("\n"); 
		query.append("AND     BCIC.BL_NO                    =   BCIB.BL_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     BB.BKG_NO                	  =   BC.BKG_NO" ).append("\n"); 
		query.append("AND		BB.BKG_STS_CD				  <>  'X'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${empty_check} != 'on') " ).append("\n"); 
		query.append("AND     BB.BKG_CGO_TP_CD        	  <> 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     BCIB.BL_DECL_TP_CD       	  =   'TI'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND BCIC.VSL_CD          = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND BCIC.SKD_VOY_NO      = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND BCIC.SKD_DIR_CD      = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND	BCIC.POD_CD			=	@[pod_cd]" ).append("\n"); 
		query.append("AND	BCIC.POL_CD			LIKE	NVL(@[pol_cd], '') || '%'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("ORDER BY TO_NUMBER(BCIB.IDA_LINE_NO)" ).append("\n"); 

	}
}