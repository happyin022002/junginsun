/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Edi315SendDBDAOSearchEventYardForReUseRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.08
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.07.08 최덕우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Choi, DukWoo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchEventYardForReUseRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * -------------------------------------------------------
	  * * History
	  * * 2011.10.24 이경원 [CHM-201113905-01] INVALID LOCATION CODE 문의 관련 처리 요청
	  * * 2013.07.05 최덕우 [CHM-201325106] [SCEM] Pseudo Yard EDI 발송 로직 변경 개발 요청
	  * </pre>
	  */
	public Edi315SendDBDAOSearchEventYardForReUseRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("event_yard",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_sts",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchEventYardForReUseRSQL").append("\n"); 
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
		query.append("SELECT (" ).append("\n"); 
		query.append("SELECT	CONTI_CD" ).append("\n"); 
		query.append("FROM	MDM_LOCATION" ).append("\n"); 
		query.append("WHERE	LOC_CD	=	SUBSTR(@[event_yard],1,5)" ).append("\n"); 
		query.append(")	CONTI_CD," ).append("\n"); 
		query.append("NOD_CD" ).append("\n"); 
		query.append("FROM	SCE_COP_HDR	H," ).append("\n"); 
		query.append("SCE_COP_DTL	D" ).append("\n"); 
		query.append("WHERE	H.COP_NO = D.COP_NO" ).append("\n"); 
		query.append("AND H.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND H.CNTR_NO =	@[cntr_no]" ).append("\n"); 
		query.append("AND D.COP_DTL_SEQ = (" ).append("\n"); 
		query.append("CASE WHEN  @[edi_sts]  = 'MT' THEN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  /*+ INDEX_DESC ( DD XPKSCE_COP_DTL ) */" ).append("\n"); 
		query.append("DD.COP_DTL_SEQ" ).append("\n"); 
		query.append("FROM    SCE_COP_DTL DD" ).append("\n"); 
		query.append("WHERE   DD.COP_NO =	H.COP_NO" ).append("\n"); 
		query.append("AND DD.STND_EDI_STS_CD = 'OAN'" ).append("\n"); 
		query.append("AND DD.COP_DTL_SEQ < @[cop_dtl_seq]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHEN  @[edi_sts]  = 'EE' THEN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  /*+ INDEX ( DD XPKSCE_COP_DTL ) */" ).append("\n"); 
		query.append("DD.COP_DTL_SEQ" ).append("\n"); 
		query.append("FROM    SCE_COP_DTL DD" ).append("\n"); 
		query.append("WHERE   DD.COP_NO =	H.COP_NO" ).append("\n"); 
		query.append("AND DD.STND_EDI_STS_CD = 'IO'" ).append("\n"); 
		query.append("AND DD.COP_DTL_SEQ > @[cop_dtl_seq]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("ELSE" ).append("\n"); 
		query.append("0" ).append("\n"); 
		query.append("END" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}