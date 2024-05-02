/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IndiaCustomsTransmissionDBDAOsearchCntrListByVvdPodMtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IndiaCustomsTransmissionDBDAOsearchCntrListByVvdPodMtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 전송대상 컨테이너 리스트를 가져옴.
	  * 2011.07.07 김현화 :CNTR Type 추가 'R9'(5500)
	  * </pre>
	  */
	public IndiaCustomsTransmissionDBDAOsearchCntrListByVvdPodMtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.integration").append("\n"); 
		query.append("FileName : IndiaCustomsTransmissionDBDAOsearchCntrListByVvdPodMtRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT SUBSTR(BCIV.CALL_SGN_NO, 1, 7) CALL_SGN_NO" ).append("\n"); 
		query.append("        ,BCIV.SKD_VOY_NO SKD_VOY_NO" ).append("\n"); 
		query.append("        ,BCIV.IDA_DECL_VSL_NO " ).append("\n"); 
		query.append("        ,VSL_DECL_DT        " ).append("\n"); 
		query.append("        ,BCIB.IDA_LINE_NO   " ).append("\n"); 
		query.append("        ,'0' TMP0" ).append("\n"); 
		query.append("        ,BCIC.CNTR_NO" ).append("\n"); 
		query.append("        ,(" ).append("\n"); 
		query.append("            SELECT CNTR_SEAL_NO" ).append("\n"); 
		query.append("            FROM   BKG_CNTR_SEAL_NO" ).append("\n"); 
		query.append("            WHERE BKG_NO = BC.BKG_NO " ).append("\n"); 
		query.append("            AND CNTR_NO = BC.CNTR_NO" ).append("\n"); 
		query.append("            AND CNTR_SEAL_SEQ > 0" ).append("\n"); 
		query.append("            AND ROWNUM = 1" ).append("\n"); 
		query.append("         ) CNTR_SEAL_NO" ).append("\n"); 
		query.append("        ,BCIV.IDA_AGN_ID" ).append("\n"); 
		query.append("        ,DECODE(BCIB.BL_NO, BCIB.NVOCC_REF_NO, DECODE(BC.CNMV_STS_CD, 'MT', 'MTY', 'FCL'), DECODE(BC.CNMV_STS_CD, 'MT', 'MTY', 'LCL')) CNMV_STS_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,DECODE(BCIB.BL_NO, BCIB.NVOCC_REF_NO, BC.PCK_QTY, BCMD.PCK_QTY) PCK_QTY" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,TRIM(DECODE(BCIB.BL_NO, BCIB.NVOCC_REF_NO, TO_CHAR(ROUND(BC.CNTR_WGT / 1000, 2), '999.00'), '2', TO_CHAR(ROUND(BCMD.CNTR_MF_WGT * 0.001, 2), '999.00'))) CNTR_WGT" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("        ,DECODE(BCIB.POD_CD, 'INMAA', DECODE(BC.CNTR_TPSZ_CD,   'D2', '2210'," ).append("\n"); 
		query.append("                                  				      		    'D4', '4210'," ).append("\n"); 
		query.append("                                  				      		    'D5', '4410'," ).append("\n"); 
		query.append("                                  				      		    'D7', '9410'," ).append("\n"); 
		query.append("                                  				      		    'R2', '2232'," ).append("\n"); 
		query.append("                                  				      		    'R5', '4432'," ).append("\n"); 
		query.append("                                  				      		    'O2', '2251'," ).append("\n"); 
		query.append("                                  				      		    'O4', '4251'," ).append("\n"); 
		query.append("                                  				      		    'F2', '2260'," ).append("\n"); 
		query.append("                                  				      		    'F4', '4260'," ).append("\n"); 
		query.append("                                  				      		    'T2', '2270'," ).append("\n"); 
		query.append("                                                                'R9', '5500'" ).append("\n"); 
		query.append("                              				      		   )" ).append("\n"); 
		query.append("                            , 'INNAH', DECODE(BC.CNTR_TPSZ_CD,  'D2', '2210'," ).append("\n"); 
		query.append("                                				      		    'D4', '4210'," ).append("\n"); 
		query.append("                                  				      		    'D5', '4510'," ).append("\n"); 
		query.append("                                 				      		    'D7', '9510'," ).append("\n"); 
		query.append("                                  				      		    'R2', '2232'," ).append("\n"); 
		query.append("                                  				      		    'R5', '4532'," ).append("\n"); 
		query.append("                                  				      		    'O2', '2251'," ).append("\n"); 
		query.append("                                  				      		    'O4', '4251'," ).append("\n"); 
		query.append("                                  				      		    'F2', '2260'," ).append("\n"); 
		query.append("                                 				      		    'F4', '4260'," ).append("\n"); 
		query.append("                                  				      		    'T2', '2270'," ).append("\n"); 
		query.append("                                                                'R9', '5500'" ).append("\n"); 
		query.append("                              				      		   )" ).append("\n"); 
		query.append("                           ,    	   DECODE(BC.CNTR_TPSZ_CD,  'D2', '2000'," ).append("\n"); 
		query.append("                                  				      		    'D4', '4000'," ).append("\n"); 
		query.append("                                  				      		    'D5', '4200'," ).append("\n"); 
		query.append("                                  				      		    'D7', '9510'," ).append("\n"); 
		query.append("                                  				      		    'R2', '2230'," ).append("\n"); 
		query.append("                                  				      		    'R5', '4230'," ).append("\n"); 
		query.append("                                  				      		    'O2', '2251'," ).append("\n"); 
		query.append("                                  				      		    'O4', '4251'," ).append("\n"); 
		query.append("                                  				      		    'F2', '2060'," ).append("\n"); 
		query.append("                                  				      		    'F4', '4060'," ).append("\n"); 
		query.append("                                  				      		    'T2', '2070'," ).append("\n"); 
		query.append("                                                                'R9', '5500'" ).append("\n"); 
		query.append("                              				      		   )" ).append("\n"); 
		query.append("                    ) CNTR_TPSZ_CD" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("       ,BC.SOC_FLG SOC_FLG," ).append("\n"); 
		query.append("       BCIV.IDA_MRN_LINE_OPR_ID" ).append("\n"); 
		query.append("FROM  BKG_CSTMS_IDA_VSL BCIV         " ).append("\n"); 
		query.append("     ,BKG_CSTMS_IDA_BL BCIB        " ).append("\n"); 
		query.append("     ,BKG_CSTMS_IDA_CNTR BCIC      " ).append("\n"); 
		query.append("     ,BKG_BL_MK_DESC BBMD          " ).append("\n"); 
		query.append("     ,BKG_CNTR_MF_DESC BCMD        " ).append("\n"); 
		query.append("     ,BKG_CONTAINER BC             " ).append("\n"); 
		query.append("     ,BKG_BOOKING BB               " ).append("\n"); 
		query.append("     ,BKG_HBL  BH                  " ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND  BCIV.VSL_CD      = BCIC.VSL_CD" ).append("\n"); 
		query.append("AND  BCIV.SKD_VOY_NO  = BCIC.SKD_VOY_NO" ).append("\n"); 
		query.append("AND  BCIV.SKD_DIR_CD  = BCIC.SKD_DIR_CD" ).append("\n"); 
		query.append("AND  BCIV.POD_CD      = BCIC.POD_CD" ).append("\n"); 
		query.append("AND  BCIC.CNTR_NO     = BC.CNTR_NO" ).append("\n"); 
		query.append("AND  BCIB.BL_NO       = BB.BL_NO" ).append("\n"); 
		query.append("AND  BCIC.VSL_CD      = BCIB.VSL_CD" ).append("\n"); 
		query.append("AND  BCIC.SKD_VOY_NO  = BCIB.SKD_VOY_NO" ).append("\n"); 
		query.append("AND  BCIC.SKD_DIR_CD  = BCIB.SKD_DIR_CD" ).append("\n"); 
		query.append("AND  BCIC.POD_CD      = BCIB.POD_CD" ).append("\n"); 
		query.append("AND  BCIC.BL_NO       = BCIB.BL_NO" ).append("\n"); 
		query.append("AND  BB.BKG_NO        = BC.BKG_NO" ).append("\n"); 
		query.append("AND  BC.CNTR_NO       = BCMD.CNTR_NO(+)" ).append("\n"); 
		query.append("AND  BB.BKG_NO        = BBMD.BKG_NO" ).append("\n"); 
		query.append("AND  BC.BKG_NO        = BCMD.BKG_NO(+)" ).append("\n"); 
		query.append("AND	 BB.BKG_STS_CD	 <>  'X'" ).append("\n"); 
		query.append("AND  BB.BKG_NO        = BH.BKG_NO(+)" ).append("\n"); 
		query.append("#if (${empty_check} != 'on') " ).append("\n"); 
		query.append("AND  BB.BKG_CGO_TP_CD    <> 'P'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND  BCIC.VSL_CD       = SUBSTR(@[vvd_cd], 1, 4)" ).append("\n"); 
		query.append("AND  BCIC.SKD_VOY_NO   = SUBSTR(@[vvd_cd], 5, 4)" ).append("\n"); 
		query.append("AND  BCIC.SKD_DIR_CD   = SUBSTR(@[vvd_cd], 9, 1)" ).append("\n"); 
		query.append("AND  BCIC.POD_CD       = @[pod_cd]" ).append("\n"); 
		query.append("AND  BCIC.POL_CD  LIKE NVL(@[pol_cd], '') || '%'" ).append("\n"); 
		query.append("AND	(( BCIB.IDA_HBL_SEQ = '00')" ).append("\n"); 
		query.append("      OR ( BCIB.IDA_HBL_SEQ <> '00'" ).append("\n"); 
		query.append("           AND BCIB.NVOCC_REF_NO = TRIM(BH.HBL_NO)" ).append("\n"); 
		query.append("           AND BBMD.MK_SEQ = BCMD.CNTR_MF_SEQ )" ).append("\n"); 
		query.append("    )" ).append("\n"); 
		query.append("ORDER BY TO_NUMBER(BCIB.IDA_LINE_NO)" ).append("\n"); 

	}
}