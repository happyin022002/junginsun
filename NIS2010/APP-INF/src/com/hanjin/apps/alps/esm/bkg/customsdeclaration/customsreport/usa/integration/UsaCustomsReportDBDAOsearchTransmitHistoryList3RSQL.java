/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchTransmitHistoryList3RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchTransmitHistoryList3RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTransmitHistoryList3
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchTransmitHistoryList3RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_tot",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_fromd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("lst_for_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_tod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("start_no",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trsm_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("snd_fromt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rct_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("end_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchTransmitHistoryList3RSQL").append("\n"); 
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
		query.append("SELECT * " ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT   CNT_CD" ).append("\n"); 
		query.append("            ,IO_BND_CD" ).append("\n"); 
		query.append("            ,STWG_SND_ID" ).append("\n"); 
		query.append("            ,SND_DATE" ).append("\n"); 
		query.append("            ,SND_DT" ).append("\n"); 
		query.append("            ,SND_TM" ).append("\n"); 
		query.append("            ,HIS_SEQ" ).append("\n"); 
		query.append("            ,DECODE(A.TRSM_MSG_TP_ID" ).append("\n"); 
		query.append("                    , 'MI', DECODE(A.CGO_TP_CD, '', A.TRSM_MSG_TP_ID, A.TRSM_MSG_TP_ID||' ('||A.CGO_TP_CD||') ')" ).append("\n"); 
		query.append("                    , 'XI', DECODE(A.CGO_TP_CD, '', A.TRSM_MSG_TP_ID, A.TRSM_MSG_TP_ID||' ('||A.CGO_TP_CD||') ')" ).append("\n"); 
		query.append("                    , A.TRSM_MSG_TP_ID) AS TRSM_MSG_TP_ID" ).append("\n"); 
		query.append("            ,VVD" ).append("\n"); 
		query.append("            ,POL_CD" ).append("\n"); 
		query.append("            ,POD_CD" ).append("\n"); 
		query.append("			,CSTMS_PORT_CD" ).append("\n"); 
		query.append("            ,OFC_CD" ).append("\n"); 
		query.append("            ,USR_ID" ).append("\n"); 
		query.append("            ,BL_NO" ).append("\n"); 
		query.append("            ,DECODE(CNTR_KNT, 0, '', CNTR_KNT) AS CNTR_KNT" ).append("\n"); 
		query.append("            ,MSG_DESC" ).append("\n"); 
		query.append("            ,ROW_NUMBER() OVER(ORDER BY SND_DATE DESC) AS RNUM" ).append("\n"); 
		query.append("            ,COUNT(*) OVER() AS TOTAL" ).append("\n"); 
		query.append("            ,RCV_DT" ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("        SELECT   DISTINCT" ).append("\n"); 
		query.append("                 L.CNT_CD" ).append("\n"); 
		query.append("                ,L.IO_BND_CD" ).append("\n"); 
		query.append("                ,'' AS STWG_SND_ID" ).append("\n"); 
		query.append("                ,L.SND_DT AS SND_DATE" ).append("\n"); 
		query.append("                ,TO_CHAR(L.SND_DT, 'YYYYMMDD') AS SND_DT" ).append("\n"); 
		query.append("                ,TO_CHAR(L.SND_DT, 'HH24MISS') AS SND_TM" ).append("\n"); 
		query.append("                ,L.HIS_SEQ" ).append("\n"); 
		query.append("                ,L.TRSM_MSG_TP_ID" ).append("\n"); 
		query.append("                ,L.VSL_CD || L.SKD_VOY_NO || L.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                ,L.VSL_CD" ).append("\n"); 
		query.append("                ,L.SKD_VOY_NO" ).append("\n"); 
		query.append("                ,L.SKD_DIR_CD" ).append("\n"); 
		query.append("                ,L.POL_CD" ).append("\n"); 
		query.append("                ,L.POD_CD" ).append("\n"); 
		query.append("                ,L.CSTMS_PORT_CD" ).append("\n"); 
		query.append("                ,L.SND_USR_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("                ,L.SND_USR_ID AS USR_ID" ).append("\n"); 
		query.append("                ,CASE WHEN TRSM_MSG_TP_ID IN ('MI','XI') THEN ''" ).append("\n"); 
		query.append("                      ELSE E.BL_NO" ).append("\n"); 
		query.append("                 END BL_NO" ).append("\n"); 
		query.append("                ,0 AS CNTR_KNT" ).append("\n"); 
		query.append("                ,'' AS MSG_DESC" ).append("\n"); 
		query.append("                ,DECODE(L.CGO_TP_CD, 'M', 'Empty', 'F', 'Full') AS CGO_TP_CD" ).append("\n"); 
		query.append("                ,(SELECT MAX(D.RCV_DT) RCV_DT FROM BKG_CSTMS_ADV_RCV_LOG D WHERE L.CNT_CD = D.CNT_CD AND L.IO_BND_CD = D.IO_BND_CD AND L.CRR_BAT_NO =  D.CRR_BAT_NO) RCV_DT" ).append("\n"); 
		query.append("        FROM     BKG_CSTMS_ADV_SND_LOG L" ).append("\n"); 
		query.append("                ,BKG_CSTMS_ADV_EDI_BL_RSPN E" ).append("\n"); 
		query.append("        WHERE    1=1" ).append("\n"); 
		query.append("        AND      L.CNT_CD = E.CNT_CD(+)" ).append("\n"); 
		query.append("        AND      L.CRR_BAT_NO = E.CRR_BAT_NO(+)" ).append("\n"); 
		query.append("    	AND      L.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("    	#if (${io_bnd_cd} != '') " ).append("\n"); 
		query.append("    	AND      L.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("        	#if (${io_bnd_cd} == 'O') " ).append("\n"); 
		query.append("    	AND      L.TRSM_MSG_TP_ID = @[trsm_msg_tp_id]" ).append("\n"); 
		query.append("	    	#else" ).append("\n"); 
		query.append("    	AND      L.TRSM_MSG_TP_ID IN ('MI','AI', 'HI', 'TI') " ).append("\n"); 
		query.append("    	    #end" ).append("\n"); 
		query.append("    	#end" ).append("\n"); 
		query.append("    	#if (${bl_no} != '') " ).append("\n"); 
		query.append("    	AND      E.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("    		#if (${io_bnd_cd} == 'O') " ).append("\n"); 
		query.append("    	AND      L.TRSM_MSG_TP_ID = @[trsm_msg_tp_id]" ).append("\n"); 
		query.append("	    	#else" ).append("\n"); 
		query.append("    	AND      L.TRSM_MSG_TP_ID IN ('MI','AI', 'HI', 'TI') " ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("    	#else" ).append("\n"); 
		query.append("        	#if (${trsm_msg_tp_id} != '' && ${trsm_msg_tp_id} != 'AL')  " ).append("\n"); 
		query.append("				#if (${io_bnd_cd} == 'O') " ).append("\n"); 
		query.append("    	    AND      L.TRSM_MSG_TP_ID = @[trsm_msg_tp_id]" ).append("\n"); 
		query.append("				#else" ).append("\n"); 
		query.append("    	    AND      L.TRSM_MSG_TP_ID = @[trsm_msg_tp_id]" ).append("\n"); 
		query.append("				#end" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        	#if (${vvd} != '') " ).append("\n"); 
		query.append("    	    AND      L.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("    	    AND      L.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("    	    AND      L.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        	#if (${pol_cd} != '') " ).append("\n"); 
		query.append("    	    AND      L.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        	#if (${pod_cd} != '') " ).append("\n"); 
		query.append("    	    AND      L.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        	#if (${snd_ofc_cd} != '') " ).append("\n"); 
		query.append("    	    AND      L.SND_USR_OFC_CD LIKE @[snd_ofc_cd] || '%'" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("        	#if (${snd_usr_id} != '') " ).append("\n"); 
		query.append("    	    AND      L.SND_USR_ID LIKE @[snd_usr_id] || '%'" ).append("\n"); 
		query.append("        	#end" ).append("\n"); 
		query.append("    		#if (${snd_fromd} != '') " ).append("\n"); 
		query.append("    	    AND 	 L.SND_DT >= TO_DATE(REPLACE(REPLACE(@[snd_fromd], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[snd_fromt], ':', ''), '-',''),'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("    		#end " ).append("\n"); 
		query.append("	    	#if (${snd_tod} != '') " ).append("\n"); 
		query.append("    	    AND 	 L.SND_DT <= TO_DATE(REPLACE(REPLACE(@[snd_tod], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[snd_tot], ':', ''), '-',''),'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("    		#end " ).append("\n"); 
		query.append("    		#if (${auto_gubun} != '') " ).append("\n"); 
		query.append("    		AND L.ACK_RCV_TP_ID = 'X'" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != 'O')     	" ).append("\n"); 
		query.append("	    	UNION" ).append("\n"); 
		query.append("	    	" ).append("\n"); 
		query.append("	    	SELECT   DISTINCT" ).append("\n"); 
		query.append("					 '' AS CNT_CD" ).append("\n"); 
		query.append("	            	,'' AS IO_BND_CD" ).append("\n"); 
		query.append("	            	,L.STWG_SND_ID   " ).append("\n"); 
		query.append("	        		,L.SND_DT AS SND_DATE" ).append("\n"); 
		query.append("	            	,TO_CHAR(L.SND_DT, 'YYYYMMDD') AS SND_DT" ).append("\n"); 
		query.append("	            	,TO_CHAR(L.SND_DT, 'HH24MISS') AS SND_TM" ).append("\n"); 
		query.append("	            	,0 AS HIS_SEQ" ).append("\n"); 
		query.append("	            	,'BAPLIE' AS TRSM_MSG_TP_ID" ).append("\n"); 
		query.append("	            	,L.VSL_CD || L.SKD_VOY_NO || L.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("	            	,L.VSL_CD" ).append("\n"); 
		query.append("					,L.SKD_VOY_NO" ).append("\n"); 
		query.append("					,L.SKD_DIR_CD" ).append("\n"); 
		query.append("	            	,L.POL_CD" ).append("\n"); 
		query.append("					,'' POD_CD" ).append("\n"); 
		query.append("	            	--,L.POD_CD" ).append("\n"); 
		query.append("					,L.CSTMS_PORT_CD" ).append("\n"); 
		query.append("	            	,L.SND_USR_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("	            	,L.SND_USR_ID AS USR_ID" ).append("\n"); 
		query.append("	            	,'' AS BL_NO" ).append("\n"); 
		query.append("	            	,L.CNTR_KNT" ).append("\n"); 
		query.append("	      	      	,'' AS MSG_DESC" ).append("\n"); 
		query.append("	      	      	,'' AS CGO_TP_CD" ).append("\n"); 
		query.append("	      	      	,sysdate RCV_DT /*temp*/" ).append("\n"); 
		query.append("	    	FROM     BKG_CSTMS_ADV_STWG_SND_LOG L" ).append("\n"); 
		query.append("	    	        ,BKG_CSTMS_ADV_STWG_CNTR C" ).append("\n"); 
		query.append("	   		WHERE    1=1" ).append("\n"); 
		query.append("	    	AND      L.STWG_SND_ID = C.STWG_SND_ID(+)" ).append("\n"); 
		query.append("	    	AND      L.SND_DT 	  = C.SND_DT(+)" ).append("\n"); 
		query.append("			AND		 L.SND_PROC_ID = 'STW'" ).append("\n"); 
		query.append("			#if (${lst_for_pol} != '') " ).append("\n"); 
		query.append("			AND      C.LODG_PORT_CD = @[lst_for_pol]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${vvd} != '') " ).append("\n"); 
		query.append("			AND      L.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("			AND      L.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("			AND      L.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${pol_cd} != '') " ).append("\n"); 
		query.append("			AND      L.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${pod_cd} != '') " ).append("\n"); 
		query.append("			AND      L.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${snd_ofc_cd} != '') " ).append("\n"); 
		query.append("	    	AND      L.SND_USR_OFC_CD LIKE @[snd_ofc_cd] || '%'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${snd_usr_id} != '') " ).append("\n"); 
		query.append("			AND      L.SND_USR_ID LIKE @[snd_usr_id] || '%'" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("			#if (${snd_fromd} != '') " ).append("\n"); 
		query.append("			AND 	 L.SND_DT >= TO_DATE(REPLACE(REPLACE(@[snd_fromd], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[snd_fromt], ':', ''), '-',''),'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("	    	#if (${snd_tod} != '') " ).append("\n"); 
		query.append("			AND 	 L.SND_DT <= TO_DATE(REPLACE(REPLACE(@[snd_tod], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[snd_tot], ':', ''), '-',''),'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("			#end " ).append("\n"); 
		query.append("    		#if (${auto_gubun} != '') /* Auto Notification MI,AI조회*/" ).append("\n"); 
		query.append("    		AND 1=2" ).append("\n"); 
		query.append("    		#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("    	" ).append("\n"); 
		query.append("#if (${io_bnd_cd} != 'O')" ).append("\n"); 
		query.append("    	UNION" ).append("\n"); 
		query.append("    	" ).append("\n"); 
		query.append("    	SELECT   DISTINCT" ).append("\n"); 
		query.append("				 '' AS CNT_CD" ).append("\n"); 
		query.append("            	,'' AS IO_BND_CD" ).append("\n"); 
		query.append("            	,L.STWG_SND_ID   " ).append("\n"); 
		query.append("        		,L.SND_DT AS SND_DATE" ).append("\n"); 
		query.append("            	,TO_CHAR(L.SND_DT, 'YYYYMMDD') AS SND_DT" ).append("\n"); 
		query.append("            	,TO_CHAR(L.SND_DT, 'HH24MISS') AS SND_TM" ).append("\n"); 
		query.append("            	,0 AS HIS_SEQ" ).append("\n"); 
		query.append("            	,'ISF-5' AS TRSM_MSG_TP_ID" ).append("\n"); 
		query.append("            	,L.VSL_CD || L.SKD_VOY_NO || L.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("            	,L.VSL_CD" ).append("\n"); 
		query.append("				,L.SKD_VOY_NO" ).append("\n"); 
		query.append("				,L.SKD_DIR_CD" ).append("\n"); 
		query.append("            	,L.POL_CD" ).append("\n"); 
		query.append("            	,L.POD_CD" ).append("\n"); 
		query.append("				,L.CSTMS_PORT_CD" ).append("\n"); 
		query.append("            	,L.SND_USR_OFC_CD AS OFC_CD" ).append("\n"); 
		query.append("            	,L.SND_USR_ID AS USR_ID" ).append("\n"); 
		query.append("            	,L.BL_NO" ).append("\n"); 
		query.append("                ,0 AS CNTR_KNT" ).append("\n"); 
		query.append("      	      	,'' AS MSG_DESC" ).append("\n"); 
		query.append("	      	    ,'' AS CGO_TP_CD" ).append("\n"); 
		query.append("     	      	,sysdate RCV_DT /*temp*/" ).append("\n"); 
		query.append("    	FROM     BKG_CSTMS_ADV_STWG_SND_LOG L" ).append("\n"); 
		query.append("   		WHERE    1=1" ).append("\n"); 
		query.append("		AND		 L.SND_PROC_ID = 'ISF'" ).append("\n"); 
		query.append("    #if (${bl_no} != '') " ).append("\n"); 
		query.append("    	AND      L.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("		#if (${vvd} != '') " ).append("\n"); 
		query.append("		AND      L.VSL_CD     = SUBSTR(@[vvd], 1, 4)" ).append("\n"); 
		query.append("		AND      L.SKD_VOY_NO = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("		AND      L.SKD_DIR_CD = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${pol_cd} != '') " ).append("\n"); 
		query.append("		AND      L.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${pod_cd} != '') " ).append("\n"); 
		query.append("		AND      L.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${snd_ofc_cd} != '') " ).append("\n"); 
		query.append("    	AND      L.SND_USR_OFC_CD LIKE @[snd_ofc_cd] || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${snd_usr_id} != '') " ).append("\n"); 
		query.append("		AND      L.SND_USR_ID LIKE @[snd_usr_id] || '%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${snd_fromd} != '') " ).append("\n"); 
		query.append("		AND 	 L.SND_DT >= TO_DATE(REPLACE(REPLACE(@[snd_fromd], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[snd_fromt], ':', ''), '-',''),'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("    	#if (${snd_tod} != '') " ).append("\n"); 
		query.append("		AND 	 L.SND_DT <= TO_DATE(REPLACE(REPLACE(@[snd_tod], '-', ''), '/', '') ||' '|| REPLACE(REPLACE(@[snd_tot], ':', ''), '-',''),'YYYYMMDD HH24MI')" ).append("\n"); 
		query.append("		#end " ).append("\n"); 
		query.append("   		#if (${auto_gubun} != '') /* Auto Notification MI,AI조회*/" ).append("\n"); 
		query.append("   		AND 1=2" ).append("\n"); 
		query.append("   		#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#end " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("	) A" ).append("\n"); 
		query.append("   #if (${rct_rhq_cd} != '' && ${vvd} != '') " ).append("\n"); 
		query.append("   ,(" ).append("\n"); 
		query.append("        SELECT OFC_CD OG_OFC_CD " ).append("\n"); 
		query.append("        FROM MDM_ORGANIZATION A" ).append("\n"); 
		query.append("        START WITH A.OFC_CD = @[rct_rhq_cd]" ).append("\n"); 
		query.append("        CONNECT BY PRIOR A.OFC_CD = A.PRNT_OFC_CD  " ).append("\n"); 
		query.append("    ) OG  " ).append("\n"); 
		query.append("    WHERE A.OFC_CD = OG.OG_OFC_CD" ).append("\n"); 
		query.append("    #end " ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE RNUM BETWEEN @[start_no] AND @[end_no]" ).append("\n"); 

	}
}