/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOActSkdEdiMntrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOActSkdEdiMntrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 입력 조건에 따라 VSK_ACT_PORT_SKD_EDI_LOG 테이블를 조회한다.
	  * ---------------------------------------------------------------------------
	  * 2011.01.25 CHM-201007580-01 진마리아 조회 조건  추가
	  * 2011.08.09 CHM-201112647-01 김민아 Actual SKD input Ratio Tab 및 조회 로직 변경 요청
	  *                                                         - 페이징 처리를 위한 조건 추가 및 쿼리 수정
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOActSkdEdiMntrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lloyd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sls_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vskd_port_rhq_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pagerows",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scs_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("call_sgn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("page_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOActSkdEdiMntrRSQL").append("\n"); 
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
		query.append("SELECT  " ).append("\n"); 
		query.append("		RCV_SEQ" ).append("\n"); 
		query.append("       ,VSL_SLAN_CD" ).append("\n"); 
		query.append("       ,VPS_PORT_CD" ).append("\n"); 
		query.append("       ,CLPT_IND_SEQ" ).append("\n"); 
		query.append("       ,YD_CD" ).append("\n"); 
		query.append("       ,TML_CD" ).append("\n"); 
		query.append("       ,EDI_VSL_NM" ).append("\n"); 
		query.append("       ,EDI_SKD_VOY_NO" ).append("\n"); 
		query.append("       ,EDI_SKD_DIR_NM" ).append("\n"); 
		query.append("       ,EDI_VVD" ).append("\n"); 
		query.append("       ,VSL_CD" ).append("\n"); 
		query.append("       ,SKD_VOY_NO" ).append("\n"); 
		query.append("       ,SKD_DIR_CD" ).append("\n"); 
		query.append("       ,VVD" ).append("\n"); 
		query.append("       ,EDI_ACT_ARR_DT" ).append("\n"); 
		query.append("       ,EDI_ACT_BRTH_DT" ).append("\n"); 
		query.append("       ,EDI_ACT_DEP_DT" ).append("\n"); 
		query.append("       ,ACT_ARR_DT" ).append("\n"); 
		query.append("       ,ACT_BRTH_DT" ).append("\n"); 
		query.append("       ,ACT_DEP_DT" ).append("\n"); 
		query.append("       ,RCV_DT" ).append("\n"); 
		query.append("       ,SCS_FLG" ).append("\n"); 
		query.append("       ,RSLT_MSG" ).append("\n"); 
		query.append("       ,SNDR_TRD_PRNR_ID" ).append("\n"); 
		query.append("       ,RCVR_TRD_PRNR_ID" ).append("\n"); 
		query.append("       ,EDI_MSG_TP_ID" ).append("\n"); 
		query.append("       ,EDI_MSG_PROC_ID" ).append("\n"); 
		query.append("       ,LLOYD_NO" ).append("\n"); 
		query.append("       ,CALL_SGN_NO" ).append("\n"); 
		query.append("       ,SHP_CALL_NO" ).append("\n"); 
		query.append("       ,CRE_USR_ID" ).append("\n"); 
		query.append("       ,CRE_DT" ).append("\n"); 
		query.append("       ,UPD_USR_ID" ).append("\n"); 
		query.append("       ,UPD_DT" ).append("\n"); 
		query.append("       ,FM_DT" ).append("\n"); 
		query.append("       ,TO_DT" ).append("\n"); 
		query.append("       ,VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append("       ,SLS_OFC_CD" ).append("\n"); 
		query.append("       ,TOTAL_CNT" ).append("\n"); 
		query.append("  FROM  (" ).append("\n"); 
		query.append("        SELECT  A.RCV_SEQ" ).append("\n"); 
		query.append("                , (SELECT VSL_SLAN_CD " ).append("\n"); 
		query.append("        		     FROM VSK_VSL_SKD" ).append("\n"); 
		query.append("        		    WHERE VSL_CD = A.VSL_CD" ).append("\n"); 
		query.append("        			  AND SKD_VOY_NO = A.SKD_VOY_NO" ).append("\n"); 
		query.append("        			  AND SKD_DIR_CD = A.SKD_DIR_CD" ).append("\n"); 
		query.append("        		  ) AS VSL_SLAN_CD" ).append("\n"); 
		query.append("                , A.VPS_PORT_CD" ).append("\n"); 
		query.append("        		, A.CLPT_IND_SEQ" ).append("\n"); 
		query.append("                , A.YD_CD" ).append("\n"); 
		query.append("                , SUBSTR(A.YD_CD, 6) AS TML_CD" ).append("\n"); 
		query.append("                , A.EDI_VSL_NM" ).append("\n"); 
		query.append("                , A.EDI_SKD_VOY_NO" ).append("\n"); 
		query.append("                , A.EDI_SKD_DIR_NM" ).append("\n"); 
		query.append("                , A.EDI_VSL_NM || A.EDI_SKD_VOY_NO || A.EDI_SKD_DIR_NM AS EDI_VVD" ).append("\n"); 
		query.append("                , A.VSL_CD" ).append("\n"); 
		query.append("                , A.SKD_VOY_NO" ).append("\n"); 
		query.append("                , A.SKD_DIR_CD" ).append("\n"); 
		query.append("                , A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("                , TO_CHAR(A.EDI_ACT_ARR_DT, 'YYYYMMDDHH24MI') AS EDI_ACT_ARR_DT" ).append("\n"); 
		query.append("                , TO_CHAR(A.EDI_ACT_BRTH_DT, 'YYYYMMDDHH24MI') AS EDI_ACT_BRTH_DT" ).append("\n"); 
		query.append("                , TO_CHAR(A.EDI_ACT_DEP_DT, 'YYYYMMDDHH24MI') AS EDI_ACT_DEP_DT" ).append("\n"); 
		query.append("                , TO_CHAR(A.ACT_ARR_DT, 'YYYYMMDDHH24MI') AS ACT_ARR_DT" ).append("\n"); 
		query.append("                , TO_CHAR(A.ACT_BRTH_DT, 'YYYYMMDDHH24MI') AS ACT_BRTH_DT" ).append("\n"); 
		query.append("                , TO_CHAR(A.ACT_DEP_DT, 'YYYYMMDDHH24MI') AS ACT_DEP_DT" ).append("\n"); 
		query.append("                , TO_CHAR(A.RCV_DT, 'YYYYMMDD') AS RCV_DT" ).append("\n"); 
		query.append("                , A.SCS_FLG" ).append("\n"); 
		query.append("                , A.RSLT_MSG" ).append("\n"); 
		query.append("        		, A.SNDR_TRD_PRNR_ID" ).append("\n"); 
		query.append("        		, A.RCVR_TRD_PRNR_ID" ).append("\n"); 
		query.append("        		, A.EDI_MSG_TP_ID" ).append("\n"); 
		query.append("        		, A.EDI_MSG_PROC_ID" ).append("\n"); 
		query.append("                , A.LLOYD_NO" ).append("\n"); 
		query.append("                , A.CALL_SGN_NO" ).append("\n"); 
		query.append("                , A.SHP_CALL_NO" ).append("\n"); 
		query.append("        		, A.CRE_USR_ID" ).append("\n"); 
		query.append("        		, A.CRE_DT" ).append("\n"); 
		query.append("        		, A.UPD_USR_ID" ).append("\n"); 
		query.append("        		, A.UPD_DT" ).append("\n"); 
		query.append("        		, '' AS FM_DT" ).append("\n"); 
		query.append("        		, '' AS TO_DT" ).append("\n"); 
		query.append("        		, B.VSKD_PORT_RHQ_CD" ).append("\n"); 
		query.append("        		, B.SLS_OFC_CD" ).append("\n"); 
		query.append("        		, COUNT(*) OVER() AS TOTAL_CNT" ).append("\n"); 
		query.append("        		, ROW_NUMBER() OVER(ORDER BY RCV_DT, RCV_SEQ) AS RNUM" ).append("\n"); 
		query.append("        FROM    	VSK_ACT_PORT_SKD_EDI_LOG 	A" ).append("\n"); 
		query.append("        		, 	MDM_LOCATION 				B" ).append("\n"); 
		query.append("					" ).append("\n"); 
		query.append("#if(${vsl_cd} != '' && ${skd_voy_no} != '' && ${skd_dir_cd} != '')" ).append("\n"); 
		query.append("				,	VSK_VSL_SKD        			T1 " ).append("\n"); 
		query.append("				,	MDM_VSL_CNTR				VC" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        WHERE   1 = 1" ).append("\n"); 
		query.append("        AND     A.VPS_PORT_CD          			= B.LOC_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${vsl_cd} != '' && ${skd_voy_no} != '' && ${skd_dir_cd} != '')" ).append("\n"); 
		query.append("		AND		A.VSL_CD						= T1.VSL_CD" ).append("\n"); 
		query.append("		AND		A.SKD_VOY_NO					= T1.SKD_VOY_NO" ).append("\n"); 
		query.append("		AND		A.SKD_DIR_CD					= T1.SKD_DIR_CD" ).append("\n"); 
		query.append("		AND		T1.VSL_CD						= VC.VSL_CD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${crr_cd} != '')" ).append("\n"); 
		query.append("AND			NVL(T1.ACT_CRR_CD,VC.CRR_CD)	= @[crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("        #if (${vps_port_cd} != '') " ).append("\n"); 
		query.append("        AND     A.VPS_PORT_CD LIKE @[vps_port_cd] || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${yd_cd} != '') " ).append("\n"); 
		query.append("        AND     A.YD_CD IN  (" ).append("\n"); 
		query.append("        		#foreach($key IN ${yd_cd}) " ).append("\n"); 
		query.append("        			#if($velocityCount < $yd_cd.size())" ).append("\n"); 
		query.append("        				'$key'," ).append("\n"); 
		query.append("        			#else" ).append("\n"); 
		query.append("        				'$key'" ).append("\n"); 
		query.append("        			#end" ).append("\n"); 
		query.append("        		#end" ).append("\n"); 
		query.append("        					)" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        AND     A.RCV_DT BETWEEN TO_DATE(@[fm_dt], 'YYYY-MM-DD') AND TO_DATE(@[to_dt], 'YYYY-MM-DD') + 0.99999" ).append("\n"); 
		query.append("        #if (${vsl_cd} != '') " ).append("\n"); 
		query.append("        AND     (A.VSL_CD = @[vsl_cd] OR A.EDI_VSL_NM = @[vsl_cd])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${skd_voy_no} != '') " ).append("\n"); 
		query.append("        AND     (A.SKD_VOY_NO = @[skd_voy_no] OR A.EDI_SKD_VOY_NO = @[skd_voy_no])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${skd_dir_cd} != '') " ).append("\n"); 
		query.append("        AND     (A.SKD_DIR_CD = @[skd_dir_cd] OR A.EDI_SKD_DIR_NM = @[skd_dir_cd])" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${scs_flg} != '' && ${scs_flg} != 'ALL' && ${rcv_dt} == '')" ).append("\n"); 
		query.append("        AND     A.SCS_FLG      = @[scs_flg]		/* RCV_DT 가 조회조건에 있으면 해당 조건제거 */" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${lloyd_no} != '')" ).append("\n"); 
		query.append("        AND     UPPER(A.LLOYD_NO)     LIKE UPPER(@[lloyd_no]) || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${call_sgn_no} != '')" ).append("\n"); 
		query.append("        AND     UPPER(A.CALL_SGN_NO)  LIKE UPPER(@[call_sgn_no]) || '%'" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${vskd_port_rhq_cd} != '' && ${vskd_port_rhq_cd} != 'ALL')" ).append("\n"); 
		query.append("        AND     B.VSKD_PORT_RHQ_CD = @[vskd_port_rhq_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${sls_ofc_cd} != '' && ${sls_ofc_cd} != 'ALL')" ).append("\n"); 
		query.append("        AND     B.SLS_OFC_CD = @[sls_ofc_cd]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${rcv_dt} != '') " ).append("\n"); 
		query.append("        AND     A.RCV_DT = TO_DATE(@[rcv_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("        #if (${rcv_seq} != '') " ).append("\n"); 
		query.append("        AND     A.RCV_SEQ = @[rcv_seq]" ).append("\n"); 
		query.append("        #end" ).append("\n"); 
		query.append("--        ORDER BY RCV_DT, RCV_SEQ" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append(" WHERE  1 = 1" ).append("\n"); 
		query.append("   AND  RNUM BETWEEN (@[page_no]-1)*@[pagerows]+1 AND @[page_no]*@[pagerows]" ).append("\n"); 

	}
}