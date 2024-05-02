/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ActualScheduleMgtDBDAOSearchActEDISetUpInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.24
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2010.03.24 임창빈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chang-Bin Lim
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ActualScheduleMgtDBDAOSearchActEDISetUpInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ActualScheduleMgtDBDAOSearchActEDISetUpInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_sub_lnk_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sndr_trd_prnr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.integration").append("\n"); 
		query.append("FileName : ActualScheduleMgtDBDAOSearchActEDISetUpInfoRSQL").append("\n"); 
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
		query.append("SELECT	NVL(MAX(DECODE(T2.EDI_MSG_IND_CD, 51, T2.MSG_TP_DESC)), 'X') AS VSL_CD_FLG" ).append("\n"); 
		query.append("		, NVL(MAX(DECODE(T2.EDI_MSG_IND_CD, 52, T2.MSG_TP_DESC)), 'X') AS MNVR_IN_HRS_FLG /* MNVR IN Hour 사용 여부로  Y이면 사용 N이면 미사용*/" ).append("\n"); 
		query.append("		, NVL(MAX(DECODE(T2.EDI_MSG_IND_CD, 53, T2.MSG_TP_DESC)), 'X') AS ACT_DATE_FLG" ).append("\n"); 
		query.append("FROM	BKG_EDI_TRD_PRNR_SUB_LNK T1, BKG_EDI_SUB_LNK_MSG T2" ).append("\n"); 
		query.append("WHERE	T1.TRD_PRNR_SUB_LNK_SEQ	= T2.TRD_PRNR_SUB_LNK_SEQ" ).append("\n"); 
		query.append("AND     T1.PRNR_SUB_LNK_DIV_CD	= '1'" ).append("\n"); 
		query.append("AND     T1.PRNR_SUB_LNK_CD	    = @[prnr_sub_lnk_cd]	/* yard code */" ).append("\n"); 
		query.append("AND		T1.SNDR_TRD_PRNR_ID     = @[sndr_trd_prnr_id]	/* sender    */" ).append("\n"); 
		query.append("AND		T2.EDI_MSG_IND_CD       IN ('51', '52', '53')" ).append("\n"); 

	}
}