/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PickUpNoticeDBDAOsearchPkupNtcHrRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.15
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.10.15 박미옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Mi Ok
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PickUpNoticeDBDAOsearchPkupNtcHrRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Form Type별 Event발생시 Notice 발송 시간에 대한 Setting 정보를 조회한다.(PkupNtcHrVO 생성)
	  * </pre>
	  */
	public PickUpNoticeDBDAOsearchPkupNtcHrRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_ntc_fom_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pkup_ntc_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration").append("\n"); 
		query.append("FileName : PickUpNoticeDBDAOsearchPkupNtcHrRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("B.PKUP_NTC_SND_TP_CD" ).append("\n"); 
		query.append(",	B.OFC_CD" ).append("\n"); 
		query.append(",	B.DEL_CD" ).append("\n"); 
		query.append(",	B.PKUP_NTC_SEQ" ).append("\n"); 
		query.append(",	NVL(A.PKUP_NTC_FOM_CD,@[pkup_ntc_fom_cd]) AS PKUP_NTC_FOM_CD" ).append("\n"); 
		query.append(",	A.NTC_SEQ" ).append("\n"); 
		query.append(",	A.NTC_BSE_HRS" ).append("\n"); 
		query.append(",	A.NTC_COND_CD" ).append("\n"); 
		query.append(",	NVL(A.MVMT_STS_CD,'NA') AS MVMT_STS_CD" ).append("\n"); 
		query.append(",	A.CRE_USR_ID" ).append("\n"); 
		query.append(",	A.CRE_DT" ).append("\n"); 
		query.append(",	A.UPD_USR_ID" ).append("\n"); 
		query.append(",	A.UPD_DT" ).append("\n"); 
		query.append("FROM BKG_PKUP_NTC_HR A," ).append("\n"); 
		query.append("(SELECT *" ).append("\n"); 
		query.append("FROM   BKG_PKUP_NTC_STUP A," ).append("\n"); 
		query.append("(SELECT LEVEL RN FROM DUAL CONNECT BY LEVEL <= 3) B" ).append("\n"); 
		query.append("WHERE A.PKUP_NTC_SEQ = @[pkup_ntc_seq]" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.PKUP_NTC_FOM_CD(+) = @[pkup_ntc_fom_cd]" ).append("\n"); 
		query.append("AND   A.PKUP_NTC_SEQ(+)    = B.PKUP_NTC_SEQ" ).append("\n"); 
		query.append("AND   A.NTC_SEQ(+)         = B.RN" ).append("\n"); 
		query.append("ORDER BY A.NTC_SEQ" ).append("\n"); 

	}
}