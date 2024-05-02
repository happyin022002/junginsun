/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingUtilDBDAOExistNoteButtonColorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOExistNoteButtonColorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ExistNoteButtonColor
	  * </pre>
	  */
	public BookingUtilDBDAOExistNoteButtonColorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_hdr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("gen_spcl_rt_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rout_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOExistNoteButtonColorRSQL").append("\n"); 
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
		query.append("SELECT NVL( (" ).append("\n"); 
		query.append("        SELECT 'Y'" ).append("\n"); 
		query.append("        FROM (" ).append("\n"); 
		query.append("            SELECT C.NOTE_TIT_NM TITLE," ).append("\n"); 
		query.append("              REPLACE(A.NOTE_CTNT, CHR(10), ' ') CONTENT," ).append("\n"); 
		query.append("              TO_CHAR(B.EFF_DT, 'YYYY-MM-DD') EFFECT_DT," ).append("\n"); 
		query.append("              TO_CHAR(B.EXP_DT, 'YYYY-MM-DD') EXPIRE_DT" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_NOTE C ," ).append("\n"); 
		query.append("              PRI_SP_SCP_NOTE_CTNT A ," ).append("\n"); 
		query.append("              PRI_SP_SCP_MN B" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND C.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("              AND C.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("              AND C.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("              AND C.NOTE_TP_CD = A.NOTE_TP_CD" ).append("\n"); 
		query.append("              AND C.NOTE_SEQ = A.NOTE_SEQ" ).append("\n"); 
		query.append("              AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("              AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("              AND A.N1ST_CMNC_AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("              AND A.NOTE_TP_CD ='P'" ).append("\n"); 
		query.append("              AND A.NOTE_CHG_TP_CD ='O'" ).append("\n"); 
		query.append("              AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("              AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("              AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT '' TITLE," ).append("\n"); 
		query.append("              REPLACE(A.NOTE_CTNT, CHR(10), ' ') CONTENT," ).append("\n"); 
		query.append("              TO_CHAR(B.EFF_DT, 'YYYY-MM-DD') EFFECT_DT," ).append("\n"); 
		query.append("              TO_CHAR(B.EXP_DT, 'YYYY-MM-DD') EXPIRE_DT" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT_CMDT_RNOTE A ," ).append("\n"); 
		query.append("              PRI_SP_SCP_MN B" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("              AND A.N1ST_CMNC_AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("              AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("              AND A.GEN_SPCL_RT_TP_CD ='S'" ).append("\n"); 
		query.append("              AND A.NOTE_CHG_TP_CD ='O'" ).append("\n"); 
		query.append("              AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("              AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("              AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("			  AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("			  AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("			  #if(${rout_seq} !='')" ).append("\n"); 
		query.append("				 AND A.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT '' TITLE," ).append("\n"); 
		query.append("              REPLACE(A.NOTE_CTNT, CHR(10), ' ') CONTENT," ).append("\n"); 
		query.append("              TO_CHAR(B.EFF_DT, 'YYYY-MM-DD') EFFECT_DT," ).append("\n"); 
		query.append("              TO_CHAR(B.EXP_DT, 'YYYY-MM-DD') EXPIRE_DT" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT_CNOTE A ," ).append("\n"); 
		query.append("              PRI_SP_SCP_MN B" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("              AND A.N1ST_CMNC_AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("              AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("              AND A.GEN_SPCL_RT_TP_CD ='S'" ).append("\n"); 
		query.append("              AND A.NOTE_CHG_TP_CD ='O'" ).append("\n"); 
		query.append("              AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("              AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("              AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("			  AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("			  AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT C.NOTE_TIT_NM TITLE," ).append("\n"); 
		query.append("              REPLACE(A.NOTE_CTNT, CHR(10), ' ') CONTENT," ).append("\n"); 
		query.append("              TO_CHAR(B.EFF_DT, 'YYYY-MM-DD') EFFECT_DT," ).append("\n"); 
		query.append("              TO_CHAR(B.EXP_DT, 'YYYY-MM-DD') EXPIRE_DT" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_NOTE C ," ).append("\n"); 
		query.append("              PRI_SP_SCP_NOTE_CTNT A ," ).append("\n"); 
		query.append("              PRI_SP_SCP_MN B" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND C.PROP_NO = A.PROP_NO" ).append("\n"); 
		query.append("              AND C.SVC_SCP_CD = A.SVC_SCP_CD" ).append("\n"); 
		query.append("              AND C.AMDT_SEQ = A.AMDT_SEQ" ).append("\n"); 
		query.append("              AND C.NOTE_TP_CD = A.NOTE_TP_CD" ).append("\n"); 
		query.append("              AND C.NOTE_SEQ = A.NOTE_SEQ" ).append("\n"); 
		query.append("              AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("              AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("              AND A.N1ST_CMNC_AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("              AND A.NOTE_TP_CD ='P'" ).append("\n"); 
		query.append("              AND A.NOTE_CHG_TP_CD ='S'" ).append("\n"); 
		query.append("              AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("              AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("              AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT '' TITLE," ).append("\n"); 
		query.append("              REPLACE(A.NOTE_CTNT, CHR(10), ' ') CONTENT," ).append("\n"); 
		query.append("              TO_CHAR(B.EFF_DT, 'YYYY-MM-DD') EFFECT_DT," ).append("\n"); 
		query.append("              TO_CHAR(B.EXP_DT, 'YYYY-MM-DD') EXPIRE_DT" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT_CMDT_RNOTE A ," ).append("\n"); 
		query.append("              PRI_SP_SCP_MN B" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("              AND A.N1ST_CMNC_AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("              AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("              AND A.GEN_SPCL_RT_TP_CD ='S'" ).append("\n"); 
		query.append("              AND A.NOTE_CHG_TP_CD ='S'" ).append("\n"); 
		query.append("              AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("              AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("              AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("			  AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("			  AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("			  #if(${rout_seq} !='')" ).append("\n"); 
		query.append("				 AND A.ROUT_SEQ = @[rout_seq]" ).append("\n"); 
		query.append("			  #end" ).append("\n"); 
		query.append("            UNION ALL" ).append("\n"); 
		query.append("            SELECT '' TITLE," ).append("\n"); 
		query.append("              REPLACE(A.NOTE_CTNT, CHR(10), ' ') CONTENT," ).append("\n"); 
		query.append("              TO_CHAR(B.EFF_DT, 'YYYY-MM-DD') EFFECT_DT," ).append("\n"); 
		query.append("              TO_CHAR(B.EXP_DT, 'YYYY-MM-DD') EXPIRE_DT" ).append("\n"); 
		query.append("            FROM PRI_SP_SCP_RT_CNOTE A ," ).append("\n"); 
		query.append("              PRI_SP_SCP_MN B" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("              AND A.PROP_NO = B.PROP_NO" ).append("\n"); 
		query.append("              AND A.N1ST_CMNC_AMDT_SEQ = B.AMDT_SEQ" ).append("\n"); 
		query.append("              AND A.SVC_SCP_CD = B.SVC_SCP_CD" ).append("\n"); 
		query.append("              AND A.GEN_SPCL_RT_TP_CD ='S'" ).append("\n"); 
		query.append("              AND A.NOTE_CHG_TP_CD ='S'" ).append("\n"); 
		query.append("              AND A.PROP_NO = @[prop_no]" ).append("\n"); 
		query.append("              AND A.AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("              AND A.SVC_SCP_CD = @[svc_scp_cd]" ).append("\n"); 
		query.append("			  AND A.GEN_SPCL_RT_TP_CD = @[gen_spcl_rt_tp_cd]" ).append("\n"); 
		query.append("			  AND A.CMDT_HDR_SEQ = @[cmdt_hdr_seq]" ).append("\n"); 
		query.append("			 ) A" ).append("\n"); 
		query.append("        WHERE ROWNUM = 1 ) , 'N') FLG" ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}