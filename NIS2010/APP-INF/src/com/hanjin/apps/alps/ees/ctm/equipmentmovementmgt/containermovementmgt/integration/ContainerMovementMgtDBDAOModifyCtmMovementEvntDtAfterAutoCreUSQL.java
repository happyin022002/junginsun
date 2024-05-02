/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOModifyCtmMovementEvntDtAfterAutoCreUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOModifyCtmMovementEvntDtAfterAutoCreUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 예를 들어 OP가 없는 상태에서 OC가 먼저 EDI 수신되었다면 auto cre에 의해 OP는 자동생성되고 event date는 OC의 것을 따른다.
	  * 이후에 OP가 EDI 수신되었다면 "OK.PROCESSED (Previous event date is later than current event date.)" 라며 튕겨져 버리지만
	  * 이런 경우 OP의 event date를 정상적으로 update 해준다.
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOModifyCtmMovementEvntDtAfterAutoCreUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_mvmt_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("evnt_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOModifyCtmMovementEvntDtAfterAutoCreUSQL").append("\n"); 
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
		query.append("UPDATE  /*+INDEX_DESC(A XAK2CTM_MOVEMENT)*/" ).append("\n"); 
		query.append("       CTM_MOVEMENT A" ).append("\n"); 
		query.append("   SET A.CNMV_EVNT_DT = TO_DATE(@[evnt_dt],'YYYYMMDDHH24MISS')," ).append("\n"); 
		query.append("       A.MVMT_CRE_TP_CD = 'S'," ).append("\n"); 
		query.append("       A.CNMV_RMK = 'event date updated by system'," ).append("\n"); 
		query.append("       A.UPD_USR_ID = @[user_id]," ).append("\n"); 
		query.append("       A.UPD_LOCL_DT = GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', SYSDATE, SUBSTR (@[evnt_yd_cd], 0, 5 ))," ).append("\n"); 
		query.append("       A.UPD_DT = SYSDATE," ).append("\n"); 
		query.append("       A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append(" WHERE A.CNTR_NO   = @[cntr_no]" ).append("\n"); 
		query.append("   AND A.ORG_YD_CD = @[evnt_yd_cd]" ).append("\n"); 
		query.append("   AND A.MVMT_CRE_TP_CD = 'A'" ).append("\n"); 
		query.append("   -- 2013.12.19 EN/TN은 동일한 MVMT type으로 간주하여 Event date update를 허용한다. " ).append("\n"); 
		query.append("   AND DECODE(A.MVMT_STS_CD, 'EN', 'EN', 'TN', 'EN', A.MVMT_STS_CD) = DECODE(@[edi_mvmt_sts_cd], 'EN', 'EN', 'TN', 'EN', @[edi_mvmt_sts_cd])" ).append("\n"); 
		query.append("   -- 새로 들어온 EVENT DATE는 기존 EDI RECEIVING DATE 보다 72H 내의  이전이어야 한다." ).append("\n"); 
		query.append("   AND A.CRE_LOCL_DT <= TO_DATE(@[evnt_dt],'YYYYMMDDHH24MISS') + 72/24" ).append("\n"); 
		query.append("   -- 새로 들어온 EVENT DATE가 이전과 이후의 EVENT DATE 사이여야 한다. (즉, CNMV_SEQ는 변하지 않아아 한다." ).append("\n"); 
		query.append("   AND TO_DATE(@[evnt_dt],'YYYYMMDDHH24MISS') BETWEEN" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("         SELECT /*+INDEX_DESC(X XUK1CTM_MOVEMENT)*/" ).append("\n"); 
		query.append("                X.CNMV_EVNT_DT" ).append("\n"); 
		query.append("           FROM CTM_MOVEMENT X" ).append("\n"); 
		query.append("          WHERE X.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("            AND X.CNMV_YR||LPAD(X.CNMV_SEQ,5,'0') < A.CNMV_YR||LPAD(A.CNMV_SEQ,5,'0')" ).append("\n"); 
		query.append("            AND ROWNUM    = 1" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("       AND" ).append("\n"); 
		query.append("       (" ).append("\n"); 
		query.append("         SELECT /*+INDEX(X XUK1CTM_MOVEMENT)*/" ).append("\n"); 
		query.append("                X.CNMV_EVNT_DT" ).append("\n"); 
		query.append("           FROM CTM_MOVEMENT X" ).append("\n"); 
		query.append("          WHERE X.CNTR_NO = A.CNTR_NO" ).append("\n"); 
		query.append("            AND X.CNMV_YR||LPAD(X.CNMV_SEQ,5,'0') > A.CNMV_YR||LPAD(A.CNMV_SEQ,5,'0')" ).append("\n"); 
		query.append("            AND ROWNUM    = 1" ).append("\n"); 
		query.append("       )" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}