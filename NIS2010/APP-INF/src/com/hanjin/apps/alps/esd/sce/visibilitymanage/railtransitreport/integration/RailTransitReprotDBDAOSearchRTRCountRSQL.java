/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RailTransitReprotDBDAOSearchRTRCountRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.10
*@LastModifier : 
*@LastVersion : 1.0
* 2013.05.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class RailTransitReprotDBDAOSearchRTRCountRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * select single
	  * </pre>
	  */
	public RailTransitReprotDBDAOSearchRTRCountRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_acpt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_cnt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsp_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("customer_loc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_nod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("sc_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("railcomp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.integration").append("\n"); 
		query.append("FileName : RailTransitReprotDBDAOSearchRTRCountRSQL").append("\n"); 
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
		query.append("select count(*) tot_cnt" ).append("\n"); 
		query.append("from (" ).append("\n"); 
		query.append("    SELECT  TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("     ,TRSP_SO_SEQ" ).append("\n"); 
		query.append("     ,EQ_NO                                                                           " ).append("\n"); 
		query.append("         FROM SCE_RAIL_TZ_RPT RPT, BKG_BOOKING BKG                                                                             " ).append("\n"); 
		query.append("         WHERE RPT.BKG_NO = BKG.BKG_NO (+) " ).append("\n"); 
		query.append("         AND NVL(RPT.DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("         " ).append("\n"); 
		query.append("				#if(${date_kind} != '')" ).append("\n"); 
		query.append("					#if(${date_kind} == 'S')" ).append("\n"); 
		query.append("      			#if(${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("        			AND RPT.SO_CRE_DT BETWEEN TO_DATE(@[fm_dt]||' 00:00:00', 'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[to_dt]||' 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("        		#end	" ).append("\n"); 
		query.append("      		#elseif(${date_kind} == 'A')" ).append("\n"); 
		query.append("      			#if(${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("						  AND RPT.DEST_AVAL_DT BETWEEN  TO_DATE(@[fm_dt]||' 00:00:00', 'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[to_dt]||' 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("      		#elseif(${date_kind} == 'O')" ).append("\n"); 
		query.append("        		#if(${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("        			AND (CASE WHEN(SELECT MAX(CASE WHEN (T.TRSP_BND_CD = 'O' AND T.POR_CD = T.POL_CD) OR (T.TRSP_BND_CD = 'I' AND T.POD_CD = T.DEL_CD)" ).append("\n"); 
		query.append("        																THEN 'ON' ELSE 'OFF' END) CHKDOCK" ).append("\n"); 
		query.append("        								FROM TRS_TRSP_RAIL_BIL_ORD T" ).append("\n"); 
		query.append("        								WHERE T.TRSP_SO_OFC_CTY_CD = RPT.TRSP_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("        								AND T.TRSP_SO_SEQ = RPT.TRSP_SO_SEQ) = 'ON' THEN RPT.DEST_AVAL_DT" ).append("\n"); 
		query.append("        						ELSE RPT.DEST_GATE_OUT_DT" ).append("\n"); 
		query.append("        			END) BETWEEN  TO_DATE(@[fm_dt]||' 00:00:00', 'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[to_dt]||' 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("      		#elseif(${date_kind} == 'I')" ).append("\n"); 
		query.append("      			#if(${fm_dt} != '' && ${to_dt} != '')" ).append("\n"); 
		query.append("						  AND RPT.ORG_GATE_IN_DT BETWEEN  TO_DATE(@[fm_dt]||' 00:00:00', 'YYYY-MM-DD HH24:MI:SS') AND TO_DATE(@[to_dt]||' 23:59:59', 'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		 #end	" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	/* BKG No && BKG No Split */" ).append("\n"); 
		query.append("	#if(${r_bkg_no} != '' || (${searchtype} == 'multi' && ${r_bkg_no} != ''))" ).append("\n"); 
		query.append("		AND ((RPT.BKG_NO) IN (" ).append("\n"); 
		query.append("	   	#if(${searchtype} == 'multi')" ).append("\n"); 
		query.append("	    	/* condition - r_bkg_no */" ).append("\n"); 
		query.append("			#if (${r_bkg_no} != '') " ).append("\n"); 
		query.append("				#foreach($ele IN ${r_bkg_no})" ).append("\n"); 
		query.append("					#if($velocityCount == 1 ) " ).append("\n"); 
		query.append("						'$ele'" ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						,'$ele' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    	#if(${bkg_no} != '')" ).append("\n"); 
		query.append("      		#if($r_bkg_no.size() > 0 && ${searchtype} == 'multi')" ).append("\n"); 
		query.append("      			," ).append("\n"); 
		query.append("      		#end" ).append("\n"); 
		query.append("      		@[bkg_no]" ).append("\n"); 
		query.append("      	#end" ).append("\n"); 
		query.append("		))" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("		#if(${bkg_no} != '')" ).append("\n"); 
		query.append("    		AND RPT.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("    /* Container No */" ).append("\n"); 
		query.append("    #if(${eq_no} != '' || (${searchtype} == 'multi' && ${r_cntr_no} != ''))" ).append("\n"); 
		query.append("		AND RPT.EQ_NO IN (" ).append("\n"); 
		query.append("		#if(${searchtype} == 'multi')" ).append("\n"); 
		query.append("			#if(${r_cntr_no} != '')" ).append("\n"); 
		query.append("    			" ).append("\n"); 
		query.append("    			#foreach($ele IN ${r_cntr_no})" ).append("\n"); 
		query.append("					#if($velocityCount == 1 ) " ).append("\n"); 
		query.append("						'$ele'" ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						,'$ele' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("      			#end" ).append("\n"); 
		query.append("      		#end" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	#if(${eq_no} != '')" ).append("\n"); 
		query.append("    		#if($r_cntr_no.size() > 0 && ${searchtype} == 'multi')" ).append("\n"); 
		query.append("      			," ).append("\n"); 
		query.append("      		#end" ).append("\n"); 
		query.append("      		@[eq_no]" ).append("\n"); 
		query.append("      	#end" ).append("\n"); 
		query.append("    	)" ).append("\n"); 
		query.append("    #end	" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("	/* B/L No */" ).append("\n"); 
		query.append("	#if(${bl_no} != '' || (${searchtype} == 'multi' && ${r_bl_no} != ''))" ).append("\n"); 
		query.append("    	AND ((MST_BL_NO) IN (" ).append("\n"); 
		query.append("    	#if(${searchtype} == 'multi')" ).append("\n"); 
		query.append("    		#if(${r_bl_no} != '')" ).append("\n"); 
		query.append("    		    #foreach($ele IN ${r_bl_no})" ).append("\n"); 
		query.append("					#if($velocityCount == 1 ) " ).append("\n"); 
		query.append("						'$ele'" ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						,'$ele' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("      			#end   	" ).append("\n"); 
		query.append("	    	#end" ).append("\n"); 
		query.append("	    #end	" ).append("\n"); 
		query.append("    	#if(${bl_no} != '')" ).append("\n"); 
		query.append("    		#if($r_bl_no.size() > 0 && ${searchtype} == 'multi')" ).append("\n"); 
		query.append("    			," ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("    	  	@[bl_no]" ).append("\n"); 
		query.append("      	#end" ).append("\n"); 
		query.append("    	))" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("	/* VVD */" ).append("\n"); 
		query.append("    #if(${vvd} != '' || (${searchtype} == 'multi' && ${r_vvd} != ''))" ).append("\n"); 
		query.append("    	AND ( RPT.VVD_CD IN ( " ).append("\n"); 
		query.append("    	#if(${searchtype} == 'multi')" ).append("\n"); 
		query.append("    		#if(${r_vvd} != '')" ).append("\n"); 
		query.append("    			#foreach($ele IN ${r_vvd})" ).append("\n"); 
		query.append("					#if($velocityCount == 1 ) " ).append("\n"); 
		query.append("						'$ele'" ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						,'$ele' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("      			#end" ).append("\n"); 
		query.append("      		#end" ).append("\n"); 
		query.append("      	#end" ).append("\n"); 
		query.append("    	#if(${vvd} != '')" ).append("\n"); 
		query.append("    		#if($r_vvd.size() > 0 && ${searchtype} == 'multi')" ).append("\n"); 
		query.append("    			," ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("      		@[vvd]" ).append("\n"); 
		query.append("      	#end" ).append("\n"); 
		query.append("    	) )" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("	/* POL , POD (MULTI) */" ).append("\n"); 
		query.append("    #if(${searchtype} == 'multi' && ${r_polpod} != '')" ).append("\n"); 
		query.append("    	AND ( RPT.NOD_CD IN (" ).append("\n"); 
		query.append("    	#if(${searchtype} == 'multi')" ).append("\n"); 
		query.append("    		#if(${r_polpod} != '')" ).append("\n"); 
		query.append("    			#foreach($ele IN ${r_polpod})" ).append("\n"); 
		query.append("					#if($velocityCount == 1 ) " ).append("\n"); 
		query.append("						'$ele'" ).append("\n"); 
		query.append("					#else " ).append("\n"); 
		query.append("						,'$ele' " ).append("\n"); 
		query.append("					#end " ).append("\n"); 
		query.append("      			#end" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("      	#end" ).append("\n"); 
		query.append("    	) )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("	/* ORIGIN (MULTI) */" ).append("\n"); 
		query.append("    #if(${searchtype} == 'multi' && ${r_origin} != '')" ).append("\n"); 
		query.append("    	AND " ).append("\n"); 
		query.append("    	#if(${r_origin} != '')" ).append("\n"); 
		query.append("	    	( RPT.FM_NOD_CD IN (" ).append("\n"); 
		query.append("	    	#foreach($ele IN ${r_origin})" ).append("\n"); 
		query.append("				#if($velocityCount == 1 ) " ).append("\n"); 
		query.append("					'$ele'" ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					,'$ele' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("      		#end" ).append("\n"); 
		query.append("      	#end" ).append("\n"); 
		query.append("      	) )" ).append("\n"); 
		query.append("    #end        " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("	/* DEST (MULTI) */" ).append("\n"); 
		query.append("    #if(${searchtype} == 'multi' && ${r_dest} != '')" ).append("\n"); 
		query.append("    	AND " ).append("\n"); 
		query.append("    	#if(${r_dest} != '')" ).append("\n"); 
		query.append("    		( RPT.TO_NOD_CD IN (" ).append("\n"); 
		query.append("    		#foreach($ele IN ${r_dest})" ).append("\n"); 
		query.append("				#if($velocityCount == 1 ) " ).append("\n"); 
		query.append("					'$ele'" ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					,'$ele' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("    	  	#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    	) )" ).append("\n"); 
		query.append("    #end    " ).append("\n"); 
		query.append("        " ).append("\n"); 
		query.append("	/* SC NO (MULTI) */" ).append("\n"); 
		query.append("    #if(${searchtype} == 'multi' && ${r_scno} != '')" ).append("\n"); 
		query.append("    	AND " ).append("\n"); 
		query.append("    	#if(${r_scno} != '')" ).append("\n"); 
		query.append("    		( RPT.SC_NO IN (" ).append("\n"); 
		query.append("    		#foreach($ele IN ${r_scno})" ).append("\n"); 
		query.append("				#if($velocityCount == 1 ) " ).append("\n"); 
		query.append("					'$ele'" ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					,'$ele' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("    	  	#end" ).append("\n"); 
		query.append("      	#end" ).append("\n"); 
		query.append("    	) )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("       " ).append("\n"); 
		query.append("	/* CUST_CNT_CD, CUST_SEQ (CUSTOMER CODE : MULTI) */" ).append("\n"); 
		query.append("    #if(${searchtype} == 'multi' && ${r_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("      	AND " ).append("\n"); 
		query.append("      	#if(${searchtype} == 'multi')" ).append("\n"); 
		query.append("      		#if(${r_cust_cnt_cd} != '')" ).append("\n"); 
		query.append("      			( EXISTS (SELECT '1' FROM BKG_CUSTOMER WHERE BKG_NO = BKG.BKG_NO AND (CUST_CNT_CD, CUST_SEQ) IN (" ).append("\n"); 
		query.append("						#foreach($ele IN ${r_cust_cnt_cd})" ).append("\n"); 
		query.append("							#if($velocityCount == 1 ) " ).append("\n"); 
		query.append("								'$ele'" ).append("\n"); 
		query.append("							#else " ).append("\n"); 
		query.append("								,'$ele' " ).append("\n"); 
		query.append("							#end " ).append("\n"); 
		query.append("				        #end" ).append("\n"); 
		query.append("       		#end" ).append("\n"); 
		query.append("   			)" ).append("\n"); 
		query.append("   		#end " ).append("\n"); 
		query.append("   		) )" ).append("\n"); 
		query.append("	#elseif(${cust_cnt_seq} != '')" ).append("\n"); 
		query.append("		AND ( EXISTS (SELECT '1' FROM BKG_CUSTOMER WHERE BKG_NO = BKG.BKG_NO AND (CUST_CNT_CD, CUST_SEQ) IN ( (" ).append("\n"); 
		query.append("    		@[cust_cnt_seq], @[cust_cnt_seq])) ) )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if(${fm_nod_cd} != '')" ).append("\n"); 
		query.append("	   	AND  RPT.fm_nod_cd LIKE @[fm_nod_cd]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("    #if(${to_nod_cd} != '')" ).append("\n"); 
		query.append("    	AND  RPT.to_nod_cd LIKE @[to_nod_cd]||'%'" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    /* BKG_OFC_CD */" ).append("\n"); 
		query.append("    #if(${bkg_ofc_cd} != '')" ).append("\n"); 
		query.append("      	AND BKG.BKG_OFC_CD IN (" ).append("\n"); 
		query.append("			#foreach($ele IN ${bkg_ofc_cd})" ).append("\n"); 
		query.append("				#if($velocityCount == 1 ) " ).append("\n"); 
		query.append("					'$ele'" ).append("\n"); 
		query.append("				#else " ).append("\n"); 
		query.append("					,'$ele' " ).append("\n"); 
		query.append("				#end " ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("		  	)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append("			" ).append("\n"); 
		query.append(" 	/* setConditionQuery(queryStr, dataSet, 'cgo_tp_cd', 'RPT', 'AND') */" ).append("\n"); 
		query.append(" 		#if(${cgo_tp_cd} != '')" ).append("\n"); 
		query.append("    		AND RPT.cgo_tp_cd = @[cgo_tp_cd]" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	/* setConditionQuery(queryStr, dataSet, 'trsp_bnd_cd', 'RPT', 'AND') */" ).append("\n"); 
		query.append("	    #if(${trsp_bnd_cd} != '')" ).append("\n"); 
		query.append("  			AND RPT.trsp_bnd_cd = @[trsp_bnd_cd]" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	/* setConditionQuery(queryStr, dataSet, 'sc_no', 'RPT', 'AND') */" ).append("\n"); 
		query.append(" 		#if(${sc_no} != '')" ).append("\n"); 
		query.append("  			AND RPT.sc_no = @[sc_no]" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append(" 			" ).append("\n"); 
		query.append(" 	/* setConditionQuery(queryStr, dataSet, 'cstms_acpt_flg', 'RPT', 'AND') */" ).append("\n"); 
		query.append(" 		#if(${cstms_acpt_flg} != '')" ).append("\n"); 
		query.append("  			AND RPT.cstms_acpt_flg = @[cstms_acpt_flg]" ).append("\n"); 
		query.append("	    #end" ).append("\n"); 
		query.append("	    " ).append("\n"); 
		query.append("	/* C/Loc */" ).append("\n"); 
		query.append(" 		#if(${customer_loc} != '')" ).append("\n"); 
		query.append("    	  	AND  RPT.IB_IPI_LOCL_IND_CD = @[customer_loc]" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("    /* POD/POL */" ).append("\n"); 
		query.append("      	#if(${pod_pol} != '')" ).append("\n"); 
		query.append("      		AND  RPT.NOD_CD LIKE @[pod_pol]||'%'" ).append("\n"); 
		query.append("      	#end" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("      	#if(${dwell_kind} != '' && ${dwell_time} != '')" ).append("\n"); 
		query.append("      	#if(${dwell_kind} == 'T')" ).append("\n"); 
		query.append("      		#if(${t_dep} != '')" ).append("\n"); 
		query.append("        		#if(${t_dep} == 'Y')" ).append("\n"); 
		query.append("        			AND RPT.TML_DEP_FLG = 'Y'" ).append("\n"); 
		query.append("        		#elseif(${t_dep} == 'N')" ).append("\n"); 
		query.append("        			AND RPT.TML_DEP_FLG = 'N'" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("      	#elseif(${dwell_kind} == 'O')" ).append("\n"); 
		query.append("      		#if(${t_dep} != '')" ).append("\n"); 
		query.append("        		#if(${t_dep} == 'Y')" ).append("\n"); 
		query.append("        			AND RPT.ORG_DEP_FLG = 'Y'" ).append("\n"); 
		query.append("        		#elseif(${t_dep} == 'N')" ).append("\n"); 
		query.append("        			AND RPT.ORG_DEP_FLG = 'N'" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("      	#elseif(${dwell_kind} == 'I1')" ).append("\n"); 
		query.append("      		#if(${t_dep} != '')" ).append("\n"); 
		query.append("        		#if(${t_dep} == 'Y')" ).append("\n"); 
		query.append("        			AND RPT.ITCHG_N1ST_DEP_FLG = 'Y'" ).append("\n"); 
		query.append("        		#elseif(${t_dep} == 'N')" ).append("\n"); 
		query.append("        			AND RPT.ITCHG_N1ST_DEP_FLG = 'N'" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("      	#elseif(${dwell_kind} == 'I2')" ).append("\n"); 
		query.append("      		#if(${t_dep} != '')" ).append("\n"); 
		query.append("        		#if(${t_dep} == 'Y')" ).append("\n"); 
		query.append("        			AND RPT.ITCHG_N2ND_DEP_FLG = 'Y'" ).append("\n"); 
		query.append("        		#elseif(${t_dep} == 'N')" ).append("\n"); 
		query.append("        			AND RPT.ITCHG_N2ND_DEP_FLG = 'N'" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("      	#elseif(${dwell_kind} == 'D1')" ).append("\n"); 
		query.append("      		#if(${t_dep} != '')" ).append("\n"); 
		query.append("        		#if(${t_dep} == 'Y')" ).append("\n"); 
		query.append("        			AND RPT.DEST_N1ST_DEP_FLG = 'Y'" ).append("\n"); 
		query.append("        		#elseif(${t_dep} == 'N')" ).append("\n"); 
		query.append("        			AND RPT.DEST_N1ST_DEP_FLG = 'N'" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("      	#elseif(${dwell_kind} == 'D2')" ).append("\n"); 
		query.append("      		#if(${t_dep} != '')" ).append("\n"); 
		query.append("        		#if(${t_dep} == 'Y')" ).append("\n"); 
		query.append("        			AND RPT.DEST_N2ND_DEP_FLG = 'Y'" ).append("\n"); 
		query.append("        		#elseif(${t_dep} == 'N')" ).append("\n"); 
		query.append("        			AND RPT.DEST_N2ND_DEP_FLG = 'N'" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("      	#end" ).append("\n"); 
		query.append("    #end  	" ).append("\n"); 
		query.append(" 				" ).append("\n"); 
		query.append(" 		AND RPT.RPT_UPD_STS_CD = 'N'" ).append("\n"); 
		query.append("    	" ).append("\n"); 
		query.append("    	/* RailCompany */" ).append("\n"); 
		query.append("    	#if(${railcomp} != '')" ).append("\n"); 
		query.append("    		AND (RPT.TRSP_SO_OFC_CTY_CD, RPT.TRSP_SO_SEQ) IN ( " ).append("\n"); 
		query.append("    			select VND.TRSP_SO_OFC_CTY_CD, VND.TRSP_SO_SEQ" ).append("\n"); 
		query.append("    			from  TRS_TRSP_RAIL_BIL_VNDR_SET VND" ).append("\n"); 
		query.append("				where VND.VNDR_SEQ = @[railcomp]" ).append("\n"); 
		query.append("    			AND   VND.SUB_RAIL_SEQ = '1'" ).append("\n"); 
		query.append("    			GROUP BY VND.TRSP_SO_OFC_CTY_CD, VND.TRSP_SO_SEQ )" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append(" " ).append("\n"); 
		query.append(" 		 " ).append("\n"); 
		query.append("      		" ).append("\n"); 
		query.append("    ) t1" ).append("\n"); 
		query.append("                                                             " ).append("\n"); 
		query.append("    #if(${dwell_kind} != '' && ${dwell_time} != '')" ).append("\n"); 
		query.append("    	#if(${dwell_kind} == 'T')" ).append("\n"); 
		query.append("    		#if(${dwell_time} == '1')" ).append("\n"); 
		query.append("		  		where t1.TML_DWLL_TM_HRS between 0 and 24" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '2')" ).append("\n"); 
		query.append("		  		where t1.TML_DWLL_TM_HRS between 25 and 48" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '3')" ).append("\n"); 
		query.append("		  		where t1.TML_DWLL_TM_HRS between 49 and 72" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '4')" ).append("\n"); 
		query.append("		  		where t1.TML_DWLL_TM_HRS between 73 and 96" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '5')" ).append("\n"); 
		query.append("		  		where t1.TML_DWLL_TM_HRS > 24" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '6')" ).append("\n"); 
		query.append("		  		where t1.TML_DWLL_TM_HRS > 48" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '7')" ).append("\n"); 
		query.append("		  		where t1.TML_DWLL_TM_HRS > 72" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '8')" ).append("\n"); 
		query.append("		  		where t1.TML_DWLL_TM_HRS > 96" ).append("\n"); 
		query.append("		  	#end    		                          " ).append("\n"); 
		query.append("    	#elseif(${dwell_kind} == 'O')" ).append("\n"); 
		query.append("    		#if(${dwell_time} == '1')" ).append("\n"); 
		query.append("		  		where t1.ORG_DWLL_TM_HRS between 0 and 24" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '2')" ).append("\n"); 
		query.append("		  		where t1.ORG_DWLL_TM_HRS between 25 and 48" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '3')" ).append("\n"); 
		query.append("		  		where t1.ORG_DWLL_TM_HRS between 49 and 72" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '4')" ).append("\n"); 
		query.append("		  		where t1.ORG_DWLL_TM_HRS between 73 and 96" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '5')" ).append("\n"); 
		query.append("		  		where t1.ORG_DWLL_TM_HRS > 24" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '6')" ).append("\n"); 
		query.append("		  		where t1.ORG_DWLL_TM_HRS > 48" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '7')" ).append("\n"); 
		query.append("		  		where t1.ORG_DWLL_TM_HRS > 72" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '8')" ).append("\n"); 
		query.append("		  		where t1.ORG_DWLL_TM_HRS > 96" ).append("\n"); 
		query.append("		  	#end " ).append("\n"); 
		query.append("    	#elseif(${dwell_kind} == 'I1')         " ).append("\n"); 
		query.append("    		#if(${dwell_time} == '1')" ).append("\n"); 
		query.append("		  		where t1.ITCHG_N1ST_DWLL_TM_HRS between 0 and 24" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '2')" ).append("\n"); 
		query.append("		  		where t1.ITCHG_N1ST_DWLL_TM_HRS between 25 and 48" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '3')" ).append("\n"); 
		query.append("		  		where t1.ITCHG_N1ST_DWLL_TM_HRS between 49 and 72" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '4')" ).append("\n"); 
		query.append("		  		where t1.ITCHG_N1ST_DWLL_TM_HRS between 73 and 96" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '5')" ).append("\n"); 
		query.append("		  		where t1.ITCHG_N1ST_DWLL_TM_HRS > 24" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '6')" ).append("\n"); 
		query.append("		  		where t1.ITCHG_N1ST_DWLL_TM_HRS > 48" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '7')" ).append("\n"); 
		query.append("		  		where t1.ITCHG_N1ST_DWLL_TM_HRS > 72" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '8')" ).append("\n"); 
		query.append("		  		where t1.ITCHG_N1ST_DWLL_TM_HRS > 96" ).append("\n"); 
		query.append("		  	#end                   " ).append("\n"); 
		query.append("    	#elseif(${dwell_kind} == 'I2')          " ).append("\n"); 
		query.append("    		#if(${dwell_time} == '1')" ).append("\n"); 
		query.append("		  		where t1.ITCHG_N2ND_DWLL_TM_HRS between 0 and 24" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '2')" ).append("\n"); 
		query.append("		  		where t1.ITCHG_N2ND_DWLL_TM_HRS between 25 and 48" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '3')" ).append("\n"); 
		query.append("		  		where t1.ITCHG_N2ND_DWLL_TM_HRS between 49 and 72" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '4')" ).append("\n"); 
		query.append("		  		where t1.ITCHG_N2ND_DWLL_TM_HRS between 73 and 96" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '5')" ).append("\n"); 
		query.append("		  		where t1.ITCHG_N2ND_DWLL_TM_HRS > 24" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '6')" ).append("\n"); 
		query.append("		  		where t1.ITCHG_N2ND_DWLL_TM_HRS > 48" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '7')" ).append("\n"); 
		query.append("		  		where t1.ITCHG_N2ND_DWLL_TM_HRS > 72" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '8')" ).append("\n"); 
		query.append("		  		where t1.ITCHG_N2ND_DWLL_TM_HRS > 96" ).append("\n"); 
		query.append("		  	#end                    " ).append("\n"); 
		query.append("    	#elseif(${dwell_kind} == 'D1')          " ).append("\n"); 
		query.append("    		#if(${dwell_time} == '1')" ).append("\n"); 
		query.append("		  		where t1.DEST_N1ST_DWLL_TM_HRS between 0 and 24" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '2')" ).append("\n"); 
		query.append("		  		where t1.DEST_N1ST_DWLL_TM_HRS between 25 and 48" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '3')" ).append("\n"); 
		query.append("		  		where t1.DEST_N1ST_DWLL_TM_HRS between 49 and 72" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '4')" ).append("\n"); 
		query.append("		  		where t1.DEST_N1ST_DWLL_TM_HRS between 73 and 96" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '5')" ).append("\n"); 
		query.append("		  		where t1.DEST_N1ST_DWLL_TM_HRS > 24" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '6')" ).append("\n"); 
		query.append("		  		where t1.DEST_N1ST_DWLL_TM_HRS > 48" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '7')" ).append("\n"); 
		query.append("		  		where t1.DEST_N1ST_DWLL_TM_HRS > 72" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '8')" ).append("\n"); 
		query.append("		  		where t1.DEST_N1ST_DWLL_TM_HRS > 96" ).append("\n"); 
		query.append("		  	#end                     " ).append("\n"); 
		query.append("    	#elseif(${dwell_kind} == 'D2')" ).append("\n"); 
		query.append("    		#if(${dwell_time} == '1')" ).append("\n"); 
		query.append("		  		where t1.DEST_N2ND_DWLL_TM_HRS between 0 and 24" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '2')" ).append("\n"); 
		query.append("		  		where t1.DEST_N2ND_DWLL_TM_HRS between 25 and 48" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '3')" ).append("\n"); 
		query.append("		  		where t1.DEST_N2ND_DWLL_TM_HRS between 49 and 72" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '4')" ).append("\n"); 
		query.append("		  		where t1.DEST_N2ND_DWLL_TM_HRS between 73 and 96" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '5')" ).append("\n"); 
		query.append("		  		where t1.DEST_N2ND_DWLL_TM_HRS > 24" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '6')" ).append("\n"); 
		query.append("		  		where t1.DEST_N2ND_DWLL_TM_HRS > 48" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '7')" ).append("\n"); 
		query.append("		  		where t1.DEST_N2ND_DWLL_TM_HRS > 72" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '8')" ).append("\n"); 
		query.append("		  		where t1.DEST_N2ND_DWLL_TM_HRS > 96" ).append("\n"); 
		query.append("		  	#end                      " ).append("\n"); 
		query.append("    	#elseif(${dwell_kind} == 'C')" ).append("\n"); 
		query.append("    		#if(${dwell_time} == '1')" ).append("\n"); 
		query.append("		  		where t1.CRNT_DWLL_TM_HRS between 0 and 24" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '2')" ).append("\n"); 
		query.append("		  		where t1.CRNT_DWLL_TM_HRS between 25 and 48" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '3')" ).append("\n"); 
		query.append("		  		where t1.CRNT_DWLL_TM_HRS between 49 and 72" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '4')" ).append("\n"); 
		query.append("		  		where t1.CRNT_DWLL_TM_HRS between 73 and 96" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '5')" ).append("\n"); 
		query.append("		  		where t1.CRNT_DWLL_TM_HRS > 24" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '6')" ).append("\n"); 
		query.append("		  		where t1.CRNT_DWLL_TM_HRS > 48" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '7')" ).append("\n"); 
		query.append("		  		where t1.CRNT_DWLL_TM_HRS > 72" ).append("\n"); 
		query.append("		  	#elseif(${dwell_time} == '8')" ).append("\n"); 
		query.append("		  		where t1.CRNT_DWLL_TM_HRS > 96" ).append("\n"); 
		query.append("		  	#end                             " ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    #end" ).append("\n"); 

	}
}