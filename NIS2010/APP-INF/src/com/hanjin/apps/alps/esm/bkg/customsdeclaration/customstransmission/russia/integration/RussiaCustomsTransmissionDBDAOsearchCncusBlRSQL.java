/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RussiaCustomsTransmissionDBDAOsearchCncusBlRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RussiaCustomsTransmissionDBDAOsearchCncusBlRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCncusBl
	  * </pre>
	  */
	public RussiaCustomsTransmissionDBDAOsearchCncusBlRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.integration").append("\n"); 
		query.append("FileName : RussiaCustomsTransmissionDBDAOsearchCncusBlRSQL").append("\n"); 
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
		query.append("	     ST.BKG_NO                                                                                                                                              " ).append("\n"); 
		query.append("                ,TO_CHAR((SELECT MAX(SKD.VPS_ETB_DT)" ).append("\n"); 
		query.append("                                   FROM     BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                                   WHERE    VVD.BKG_NO 		= ST.BKG_NO" ).append("\n"); 
		query.append("                                   AND      VVD.VSL_CD 		= SKD.VSL_CD" ).append("\n"); 
		query.append("                                   AND      VVD.SKD_VOY_NO 	= SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                                   AND      VVD.SKD_DIR_CD 	= SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("                                   AND      VVD.POL_CD 		= SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("                                   AND      VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ), 'YYYYMMDD') 	VPS_ETB_DT                                                                                                 " ).append("\n"); 
		query.append("                ,TO_CHAR(ST.POD_ETA_DT, 'YYYYMMDD')   			BL_POD_ETA_DT                                                                                                  " ).append("\n"); 
		query.append("                ,TO_CHAR(ISS.OBL_ISS_DT, 'YYYYMMDD')		   	BL_ISS_DT                                                                                              " ).append("\n"); 
		query.append("                ,MO.LOC_CD	            						BL_ISS_LOC_CD                                                                                                             " ).append("\n"); 
		query.append("                ,LOC5.LOC_NM                					BL_ISS_LOC_NM                                                                                                              " ).append("\n"); 
		query.append("                ,ST.POR_CD		 								POR_CD                                                                                                                        " ).append("\n"); 
		query.append("                ,LOC1.LOC_NM	    							POR_NM                                                                                                                         " ).append("\n"); 
		query.append("                ,ST.POL_CD		 								BKG_POL_CD " ).append("\n"); 
		query.append("				,ST.POD_CD		 								BKG_POD_CD " ).append("\n"); 
		query.append("				,ST.DEL_CD		 								DEL_CD                                                                                                                  " ).append("\n"); 
		query.append("                ,LOC2.LOC_NM	          						POL_NM                                                                                                                      " ).append("\n"); 
		query.append("                ,LOC3.LOC_NM	         						POD_NM         " ).append("\n"); 
		query.append("                ,LOC4.LOC_NM	        						DEL_NM                                                                                                                              " ).append("\n"); 
		query.append("                ,ST.RCV_TERM_CD||ST.DE_TERM_CD              	RD_TERM                   	                                                                                                                         " ).append("\n"); 
		query.append("                ,BKG_SPCLCHAR_CONV_FNC(TRIM(S.CUST_NM), 'C')   S_CUST_NM                                                                                                                         " ).append("\n"); 
		query.append("                ,BKG_SPCLCHAR_CONV_FNC(TRIM(S.CUST_ADDR), 'C') S_CUST_ADDR                                                                                             " ).append("\n"); 
		query.append("                ,BKG_SPCLCHAR_CONV_FNC(TRIM(C.CUST_NM), 'C')   C_CUST_NM            	                                                                                                         " ).append("\n"); 
		query.append("                ,BKG_SPCLCHAR_CONV_FNC(TRIM(C.CUST_ADDR), 'C') C_CUST_ADDR                                                                                                 " ).append("\n"); 
		query.append("                ,BKG_SPCLCHAR_CONV_FNC(TRIM(N.CUST_NM), 'C')   N_CUST_NM                                                                                                                          " ).append("\n"); 
		query.append("                ,BKG_SPCLCHAR_CONV_FNC(TRIM(N.CUST_ADDR), 'C') N_CUST_ADDR                                                                                                                      " ).append("\n"); 
		query.append("                ,NVL(TRIM(DOC.CSTMS_DESC),'N/M') 				CSTMS_DESC" ).append("\n"); 
		query.append("                ,SUBSTR(TRIM(SM.BL_MK_DESC),1,500) 				BL_MK_DESC" ).append("\n"); 
		query.append("                ,DOC.ACT_WGT									ACT_WGT	                                                                                                             " ).append("\n"); 
		query.append("                ,DOC.PCK_QTY	            					PCK_QTY	                                                                                                                 " ).append("\n"); 
		query.append("                ,DOC.PCK_TP_CD			    					PCK_TP_CD" ).append("\n"); 
		query.append("				,MPT.PCK_NM                                     BLPKGU_NM                                                                                                " ).append("\n"); 
		query.append("                ,DOC.MEAS_QTY	" ).append("\n"); 
		query.append("			    ,DECODE(BR.FRT_TERM_CD,'P','PP','C','CC')  		PRFLAG                                                " ).append("\n"); 
		query.append("FROM	BKG_VVD VVD," ).append("\n"); 
		query.append("        BKG_BOOKING ST,   " ).append("\n"); 
		query.append("        BKG_BL_DOC DOC," ).append("\n"); 
		query.append("    	BKG_CUSTOMER C,                                                                                                                                        " ).append("\n"); 
		query.append("    	BKG_CUSTOMER S,                                                                                                                                        " ).append("\n"); 
		query.append("    	BKG_CUSTOMER N,                                                                                                                                        " ).append("\n"); 
		query.append("    	MDM_LOCATION LOC1,                                                                                                                                           " ).append("\n"); 
		query.append("    	MDM_LOCATION LOC2,                                                                                                                                           " ).append("\n"); 
		query.append("    	MDM_LOCATION LOC3,                                                                                                                                           " ).append("\n"); 
		query.append("    	MDM_LOCATION LOC4," ).append("\n"); 
		query.append(" 		MDM_LOCATION LOC5,                                                                                                                                           " ).append("\n"); 
		query.append("    	MDM_ORGANIZATION MO," ).append("\n"); 
		query.append("		MDM_PCK_TP  MPT," ).append("\n"); 
		query.append("        BKG_BL_ISS ISS," ).append("\n"); 
		query.append("		BKG_RATE   BR," ).append("\n"); 
		query.append("        ( SELECT  BKG_NO, DBMS_LOB.SUBSTR( BKG_SPCLCHAR_CONV_CLOB_FNC(MK_DESC,'C'), DBMS_LOB.GetLength(BKG_SPCLCHAR_CONV_CLOB_FNC(MK_DESC,'C')) ) BL_MK_DESC                                                                    " ).append("\n"); 
		query.append("          FROM    BKG_BL_MK_DESC                                                                                                                                   " ).append("\n"); 
		query.append("          WHERE	  1=1                                                                                                                                                  " ).append("\n"); 
		query.append("		  AND   ( #foreach($field_id in ${field_list})                                                                                                                           " ).append("\n"); 
		query.append("      	#if($velocityCount > 1)                                                                                                                                      " ).append("\n"); 
		query.append("      	OR #end      BKG_NO IN ( $field_id )                                                                                                                       " ).append("\n"); 
		query.append("      #end                                                                                                                                                           " ).append("\n"); 
		query.append(")     " ).append("\n"); 
		query.append("		) SM                                                                                                                               " ).append("\n"); 
		query.append("WHERE	1=1                                                                                                                                                          " ).append("\n"); 
		query.append("AND ( #foreach($field_id in ${field_list})                                                                                                                           " ).append("\n"); 
		query.append("      	#if($velocityCount > 1)                                                                                                                                      " ).append("\n"); 
		query.append("      	OR #end     VVD.BKG_NO IN ( $field_id )                                                                                                                       " ).append("\n"); 
		query.append("      #end                                                                                                                                                           " ).append("\n"); 
		query.append(")   " ).append("\n"); 
		query.append("#if ( ${mode_type} == 'I' ) " ).append("\n"); 
		query.append("AND VVD.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("AND VVD.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND VVD.BKG_NO = ST.BKG_NO" ).append("\n"); 
		query.append("AND ST.BKG_NO = DOC.BKG_NO" ).append("\n"); 
		query.append("AND	    ST.BKG_NO		      =	C.BKG_NO(+)" ).append("\n"); 
		query.append("AND	    C.BKG_CUST_TP_CD(+)	  =	'C'" ).append("\n"); 
		query.append("AND	    ST.BKG_NO		      =	S.BKG_NO(+)" ).append("\n"); 
		query.append("AND	    S.BKG_CUST_TP_CD(+)	  =	'S'" ).append("\n"); 
		query.append("AND	    ST.BKG_NO		      =	N.BKG_NO(+)                                                                                                                        " ).append("\n"); 
		query.append("AND	    N.BKG_CUST_TP_CD(+)	  =	'N'                                                                                                                                  " ).append("\n"); 
		query.append("AND	    ST.POR_CD		      =	LOC1.LOC_CD                                                                                                                          " ).append("\n"); 
		query.append("ANd	    ST.POL_CD	      	  =	LOC2.LOC_CD                                                                                                                          " ).append("\n"); 
		query.append("AND	    ST.POD_CD	      	  =	LOC3.LOC_CD                                                                                                                          " ).append("\n"); 
		query.append("AND	    ST.DEL_CD	      	  =	LOC4.LOC_CD  " ).append("\n"); 
		query.append("AND     ST.BKG_NO = ISS.BKG_NO" ).append("\n"); 
		query.append("AND	    ISS.OBL_ISS_OFC_CD    =	MO.OFC_CD(+)" ).append("\n"); 
		query.append("AND     MO.LOC_CD             =  LOC5.LOC_CD(+)                                                                                                                       " ).append("\n"); 
		query.append("AND	    ST.BKG_NO		      =	SM.BKG_NO(+)" ).append("\n"); 
		query.append("AND		ST.BKG_NO = BR.BKG_NO(+)" ).append("\n"); 
		query.append("AND     DOC.PCK_TP_CD    =  MPT.PCK_CD(+)" ).append("\n"); 

	}
}