/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Edi315SendDBDAOSearchUSA00094VAMissedRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.19 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchUSA00094VAMissedRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Edi315SendDBDAOSearchUSA00094VAMissedRSQL.Query
	  * </pre>
	  */
	public Edi315SendDBDAOSearchUSA00094VAMissedRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchUSA00094VAMissedRSQL").append("\n"); 
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
		query.append("    (" ).append("\n"); 
		query.append("    SELECT COUNT(*) CNT " ).append("\n"); 
		query.append("    FROM SCE_EDI_SND_RSLT " ).append("\n"); 
		query.append("    WHERE 1=1 " ).append("\n"); 
		query.append("        AND EDI_GRP_CD='USA00094' " ).append("\n"); 
		query.append("        AND EDI_STS_CD='VAD' " ).append("\n"); 
		query.append("        AND EDI_SND_TP_CD='Y' " ).append("\n"); 
		query.append("        AND BKG_NO=@[bkg_no]" ).append("\n"); 
		query.append("        AND CNTR_NO=@[cntr_no] " ).append("\n"); 
		query.append("    ) CNT, " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT TO_CHAR(MAX(ACT_DT)-2,'YYYYMMDDHH24MISS') EVENT_DT_VAD " ).append("\n"); 
		query.append("    FROM SCE_COP_DTL " ).append("\n"); 
		query.append("    WHERE COP_NO = ( SELECT COP_NO FROM SCE_COP_HDR WHERE BKG_NO=@[bkg_no] AND CNTR_NO=@[cntr_no] AND ROWNUM=1 ) " ).append("\n"); 
		query.append("        AND STND_EDI_STS_CD = 'OAN' " ).append("\n"); 
		query.append("    ) EVENT_DT_VAD, " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT COP_DTL_SEQ AS EVENT_COP_DTL_SEQ " ).append("\n"); 
		query.append("    FROM SCE_COP_DTL " ).append("\n"); 
		query.append("    WHERE COP_NO = ( SELECT COP_NO FROM SCE_COP_HDR WHERE BKG_NO=@[bkg_no] AND CNTR_NO=@[cntr_no] AND ROWNUM=1 ) " ).append("\n"); 
		query.append("        AND STND_EDI_STS_CD = 'VAD' " ).append("\n"); 
		query.append("        AND ROWNUM = 1" ).append("\n"); 
		query.append("    ) EVENT_COP_DTL_SEQ , " ).append("\n"); 
		query.append("    (" ).append("\n"); 
		query.append("    SELECT NOD_CD AS EVENT_YARD " ).append("\n"); 
		query.append("    FROM SCE_COP_DTL " ).append("\n"); 
		query.append("    WHERE COP_NO = ( SELECT COP_NO FROM SCE_COP_HDR WHERE BKG_NO=@[bkg_no] AND CNTR_NO=@[cntr_no] AND ROWNUM=1 ) " ).append("\n"); 
		query.append("        AND STND_EDI_STS_CD = 'VAD' " ).append("\n"); 
		query.append("        AND ROWNUM = 1 " ).append("\n"); 
		query.append("    ) EVENT_YARD  " ).append("\n"); 
		query.append("FROM DUAL" ).append("\n"); 

	}
}