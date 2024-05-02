/*=========================================================
*Copyright(c) 2018 SM Line
*@FileName : ChinaCustomsTransmissionDBDAOsearchCncusBlAgnRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.05.29
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChinaCustomsTransmissionDBDAOsearchCncusBlAgnRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ChinaCncusBlListVO
	  * </pre>
	  */
	public ChinaCustomsTransmissionDBDAOsearchCncusBlAgnRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trans_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.integration").append("\n"); 
		query.append("FileName : ChinaCustomsTransmissionDBDAOsearchCncusBlAgnRSQL").append("\n"); 
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
		query.append("SELECT	/*+ ORDERED */                                                                                                                                               " ).append("\n"); 
		query.append("	     ST.BL_NO                                                                                                                                                    " ).append("\n"); 
		query.append("		,MAX (  ST.BL_NO                                                                                                                                            " ).append("\n"); 
		query.append("                ||CHR(9)||TO_CHAR(NVL(BL_OBRD_DT,(SELECT MAX(V.VPS_ETB_DT)" ).append("\n"); 
		query.append("                                   				  FROM VSK_VSL_PORT_SKD V, BKG_VVD B" ).append("\n"); 
		query.append("                                   				  WHERE V.VSL_CD = ST.VSL_CD " ).append("\n"); 
		query.append("                                   				  AND V.SKD_VOY_NO = ST.SKD_VOY_NO " ).append("\n"); 
		query.append("                                   				  AND V.SKD_DIR_CD = ST.SKD_DIR_CD " ).append("\n"); 
		query.append("                                   				  AND V.VPS_PORT_CD = ST.PORT_CD" ).append("\n"); 
		query.append("                                   				  AND B.BKG_NO = ST.BKG_NO AND B.VSL_CD = V.VSL_CD AND B.SKD_VOY_NO = V.SKD_VOY_NO AND B.SKD_DIR_CD = V.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   				  AND V.CLPT_IND_SEQ = DECODE(B.POL_CD,ST.PORT_CD,B.POL_CLPT_IND_SEQ,B.POD_CLPT_IND_SEQ))), 'YYYYMMDD')		                                                                                                 " ).append("\n"); 
		query.append("                ||CHR(9)||TO_CHAR(ST.BL_POD_ETA_DT, 'YYYYMMDD')                                                                                                     " ).append("\n"); 
		query.append("                ||CHR(9)||TO_CHAR(ST.BL_ISS_DT, 'YYYYMMDD')		                                                                                                 " ).append("\n"); 
		query.append("                ||CHR(9)||ST.BL_ISS_OFC_CD	                                                                                                                         " ).append("\n"); 
		query.append("                ||CHR(9)||LOC5.LOC_NM                                                                                                                               " ).append("\n"); 
		query.append("                ||CHR(9)||ST.POR_CD		                                                                                                                         " ).append("\n"); 
		query.append("                ||CHR(9)||LOC1.LOC_NM	                                                                                                                             " ).append("\n"); 
		query.append("                ||CHR(9)||ST.BKG_POL_CD		                                                                                                                     " ).append("\n"); 
		query.append("                ||CHR(9)||LOC2.LOC_NM	                                                                                                                             " ).append("\n"); 
		query.append("                ||CHR(9)||ST.BKG_POD_CD                                                                                                                             " ).append("\n"); 
		query.append("                ||CHR(9)||LOC3.LOC_NM	                                                                                                                             " ).append("\n"); 
		query.append("                ||CHR(9)||ST.DEL_CD		                                                                                                                         " ).append("\n"); 
		query.append("                ||CHR(9)||LOC4.LOC_NM	                                                                                                                             " ).append("\n"); 
		query.append("                ||CHR(9)||ST.CHN_CSTMS_TRSP_MOD_CD	                                                                                                                 " ).append("\n"); 
		query.append("                ||CHR(9)||ST.RCV_TERM_CD||ST.DE_TERM_CD                                                                                                             " ).append("\n"); 
		query.append("				#if (${trans_mode} == 'O')                                                                                                                           " ).append("\n"); 
		query.append("                ||CHR(9)||DECODE(ST.FRT_TERM_CD,'P','PP','C','CC')                                                                                                  " ).append("\n"); 
		query.append("				#else                                                                                                                                                " ).append("\n"); 
		query.append("                ||CHR(9)||ST.FRT_TERM_CD                                                                                                                            " ).append("\n"); 
		query.append("				#end						                                                                                                                         " ).append("\n"); 
		query.append("                ||CHR(9)||TRIM(S.CUST_NM)                                                                                                                           " ).append("\n"); 
		query.append("                ||CHR(9)||TRIM(S.CUST_ADDR)                                                                                                                         " ).append("\n"); 
		query.append("                ||CHR(9)||''                         			                                                                                                     " ).append("\n"); 
		query.append("                ||CHR(9)||''                                                                                                                                        " ).append("\n"); 
		query.append("                ||CHR(9)||''    							                                                                                                         " ).append("\n"); 
		query.append("                ||CHR(9)||TRIM(C.CUST_NM)               	                                                                                                         " ).append("\n"); 
		query.append("                ||CHR(9)||TRIM(C.CUST_ADDR)             	                                                                                                         " ).append("\n"); 
		query.append("                ||CHR(9)||''                         			                                                                                                     " ).append("\n"); 
		query.append("                ||CHR(9)||''                         			                                                                                                     " ).append("\n"); 
		query.append("                ||CHR(9)||''                         			                                                                                                     " ).append("\n"); 
		query.append("                ||CHR(9)||TRIM(N.CUST_NM)                                                                                                                           " ).append("\n"); 
		query.append("                ||CHR(9)||TRIM(N.CUST_ADDR)                                                                                                                         " ).append("\n"); 
		query.append("                ||CHR(9)||''                         			                                                                                                     " ).append("\n"); 
		query.append("                ||CHR(9)||''                                                                                                                                        " ).append("\n"); 
		query.append("                ||CHR(9)||''						                                                                                                       " ).append("\n"); 
		query.append("                ||CHR(9)||ST.POD_ROUT_DESC                                                                                                            " ).append("\n"); 
		query.append("                --||CHR(9)||REPLACE(ST.POD_ROUT_DESC,';',CHR(9))                                                                                                     " ).append("\n"); 
		query.append("                ||CHR(9)||NVL(TRIM(ST.CSTMS_DESC),'N/M')                                                                                                                             " ).append("\n"); 
		query.append("                ||CHR(9)||SUBSTR(SM.BL_MK_DESC, 1, INSTR(SM.BL_MK_DESC, CHR(9), 1,1)-2)                                                                            " ).append("\n"); 
		query.append("                ||CHR(9)||SUBSTR(SM.BL_MK_DESC, INSTR(SM.BL_MK_DESC, CHR(9), 1, 1)+1,	INSTR(SM.BL_MK_DESC, CHR(9), 1, 2) - INSTR(SM.BL_MK_DESC, CHR(9),	1, 1) -2)" ).append("\n"); 
		query.append("                ||CHR(9)||SUBSTR(SM.BL_MK_DESC, INSTR(SM.BL_MK_DESC, CHR(9), 1, 2)+1, INSTR(SM.BL_MK_DESC, CHR(9), 1, 3) - INSTR(SM.BL_MK_DESC, CHR(9), 1, 2) -2)" ).append("\n"); 
		query.append("                ||CHR(9)||SUBSTR(SM.BL_MK_DESC, INSTR(SM.BL_MK_DESC, CHR(9), 1, 3)+1, INSTR(SM.BL_MK_DESC, CHR(9), 1, 4) - INSTR(SM.BL_MK_DESC, CHR(9), 1, 3) -2)" ).append("\n"); 
		query.append("                ||CHR(9)||SUBSTR(SM.BL_MK_DESC, INSTR(SM.BL_MK_DESC, CHR(9), 1, 4)+1, INSTR(SM.BL_MK_DESC, CHR(9), 1, 5) - INSTR(SM.BL_MK_DESC, CHR(9), 1, 4) -2)" ).append("\n"); 
		query.append("                ||CHR(9)||ST.ACT_WGT					                                                                                                             " ).append("\n"); 
		query.append("                ||CHR(9)||ST.PCK_QTY	                                                                                                                             " ).append("\n"); 
		query.append("                ||CHR(9)||ST.PCK_TP_CD" ).append("\n"); 
		query.append("				||CHR(9)||NVL2(RF.BL_NO,'Y','N')				                                                                                                                 " ).append("\n"); 
		query.append("                ||CHR(9)||DECODE(RF.FDO_TEMP, NULL, DECODE(RF.CDO_TEMP, NULL, 0, RF.CDO_TEMP), RF.FDO_TEMP)  " ).append("\n"); 
		query.append("                ||CHR(9)||DECODE(RF.FDO_TEMP, NULL, 'C', 'F')                                                                                                     " ).append("\n"); 
		query.append("                ||CHR(9)||ST.MEAS_QTY		                                                                                                             " ).append("\n"); 
		query.append("                ||CHR(9)||'1'	" ).append("\n"); 
		query.append("                ||CHR(9)||DECODE(S.RGST_NO, NULL, ''" ).append("\n"); 
		query.append("										        , '9999+'||S.RGST_NO" ).append("\n"); 
		query.append("                ||CHR(9)||DECODE(C.RGST_NO, NULL, ''" ).append("\n"); 
		query.append("												, DECODE(C.CO_CHN_TP_CD), 'U', 'USCI+'||C.RGST_NO" ).append("\n"); 
		query.append("												 						, 'O', 'OC+'||C.RGST_NO" ).append("\n"); 
		query.append("												  						, 'B', '9999+'||C.RGST_NO" ).append("\n"); 
		query.append("												  	 						 , '9999+'||C.RGST_NO" ).append("\n"); 
		query.append("														)" ).append("\n"); 
		query.append("								) " ).append("\n"); 
		query.append("                ||CHR(9)||DECODE(N.RGST_NO, NULL, ''" ).append("\n"); 
		query.append("												, DECODE(N.CO_CHN_TP_CD, 'U', 'USCI+'||N.RGST_NO" ).append("\n"); 
		query.append("												  						 'O', 'OC+'||N.RGST_NO" ).append("\n"); 
		query.append("												  						 'B', '9999+'||N.RGST_NO" ).append("\n"); 
		query.append("													 						, '9999+'||N.RGST_NO" ).append("\n"); 
		query.append("														)" ).append("\n"); 
		query.append("								)" ).append("\n"); 
		query.append("		  ) BL_DATA                                                                                                                            " ).append("\n"); 
		query.append("FROM	BKG_CSTMS_CHN_BL ST,                                                                                                                                         " ).append("\n"); 
		query.append("    	BKG_CSTMS_CHN_CUST C,                                                                                                                                        " ).append("\n"); 
		query.append("    	BKG_CSTMS_CHN_CUST S,                                                                                                                                        " ).append("\n"); 
		query.append("    	BKG_CSTMS_CHN_CUST N,                                                                                                                                        " ).append("\n"); 
		query.append("    	MDM_LOCATION LOC1,                                                                                                                                           " ).append("\n"); 
		query.append("    	MDM_LOCATION LOC2,                                                                                                                                           " ).append("\n"); 
		query.append("    	MDM_LOCATION LOC3,                                                                                                                                           " ).append("\n"); 
		query.append("    	MDM_LOCATION LOC4,                                                                                                                                           " ).append("\n"); 
		query.append("    	MDM_LOCATION LOC5,                                                                                                                                           " ).append("\n"); 
		query.append("    	BKG_CSTMS_CHN_RF RF,                                                                                                                                         " ).append("\n"); 
		query.append("        ( SELECT  BL_NO, DBMS_LOB.SUBSTR( BL_MK_DESC, DBMS_LOB.GetLength(BL_MK_DESC) ) BL_MK_DESC                                                                    " ).append("\n"); 
		query.append("          FROM    BKG_CSTMS_CHN_MK                                                                                                                                   " ).append("\n"); 
		query.append("          WHERE	  1=1                                                                                                                                                  " ).append("\n"); 
		query.append("		  AND   ( #foreach($field_id in ${field_list})                                                                                                               " ).append("\n"); 
		query.append("      				#if($velocityCount > 1)                                                                                                                          " ).append("\n"); 
		query.append("      				OR #end      BL_NO IN ( $field_id )                                                                                                              " ).append("\n"); 
		query.append("      			  #end                                                                                                                                               " ).append("\n"); 
		query.append("		  )" ).append("\n"); 
		query.append("          AND     CHN_MF_SND_IND_CD  =	@[trans_mode]" ).append("\n"); 
		query.append("		) SM                                                                                                                                                  " ).append("\n"); 
		query.append("WHERE	1=1                                                                                                                                                          " ).append("\n"); 
		query.append("AND ( #foreach($field_id in ${field_list})                                                                                                                           " ).append("\n"); 
		query.append("      	#if($velocityCount > 1)                                                                                                                                      " ).append("\n"); 
		query.append("      	OR #end      ST.BL_NO IN ( $field_id )                                                                                                                       " ).append("\n"); 
		query.append("      #end                                                                                                                                                           " ).append("\n"); 
		query.append(")                                                                                                                                                                    " ).append("\n"); 
		query.append("AND	    ST.CHN_MF_SND_IND_CD  =	@[trans_mode]   /*24hr*/                                                                            " ).append("\n"); 
		query.append("AND	    ST.BKG_POD_CD		  =	@[pod] 			/*24hr*/" ).append("\n"); 
		query.append("AND	    ST.BL_NO		      =	C.BL_NO(+)" ).append("\n"); 
		query.append("AND	    ST.CHN_MF_SND_IND_CD  =	C.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("AND	    C.BKG_CUST_TP_CD(+)	  =	'C'" ).append("\n"); 
		query.append("AND	    ST.BL_NO		      =	S.BL_NO(+)" ).append("\n"); 
		query.append("AND	    ST.CHN_MF_SND_IND_CD  =	S.CHN_MF_SND_IND_CD(+)" ).append("\n"); 
		query.append("AND	    S.BKG_CUST_TP_CD(+)	  =	'S'" ).append("\n"); 
		query.append("AND	    ST.BL_NO		      =	N.BL_NO(+)" ).append("\n"); 
		query.append("AND	    ST.CHN_MF_SND_IND_CD  =	N.CHN_MF_SND_IND_CD(+)                                                                                                                          " ).append("\n"); 
		query.append("AND	    N.BKG_CUST_TP_CD(+)	  =	'N'                                                                                                                                  " ).append("\n"); 
		query.append("AND	    ST.POR_CD		      =	LOC1.LOC_CD                                                                                                                          " ).append("\n"); 
		query.append("ANd	    ST.BKG_POL_CD	      =	LOC2.LOC_CD                                                                                                                          " ).append("\n"); 
		query.append("AND	    ST.BKG_POD_CD	      =	LOC3.LOC_CD                                                                                                                          " ).append("\n"); 
		query.append("AND	    ST.DEL_CD	      	  =	LOC4.LOC_CD                                                                                                                          " ).append("\n"); 
		query.append("AND	    ST.BL_ISS_OFC_CD      =	LOC5.LOC_CD(+)                                                                                                                       " ).append("\n"); 
		query.append("AND	    ST.BL_NO		      =	SM.BL_NO(+)                                                                                                                          " ).append("\n"); 
		query.append("AND	    ST.BL_NO		      =	RF.BL_NO(+)                                                                                                                          " ).append("\n"); 
		query.append("AND	    ST.CHN_MF_SND_IND_CD  =	RF.CHN_MF_SND_IND_CD(+)                                                                                                              " ).append("\n"); 
		query.append("GROUP BY ST.BL_NO" ).append("\n"); 

	}
}