/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndExpCustomsTransmissionDBDAOsearchCndCstmsRcvHisListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.27 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndExpCustomsTransmissionDBDAOsearchCndCstmsRcvHisListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCndCstmsRcvHisList
	  * </pre>
	  */
	public CndExpCustomsTransmissionDBDAOsearchCndCstmsRcvHisListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_rcv_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rcv_dt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.integration").append("\n"); 
		query.append("FileName : CndExpCustomsTransmissionDBDAOsearchCndCstmsRcvHisListRSQL").append("\n"); 
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
		query.append("SELECT  A.RCV_MSG_TP_ID " ).append("\n"); 
		query.append("       ,TO_CHAR(A.RCV_DT,'YYYY-MM-DD  HH24:MI:SS') AS RCV_DT" ).append("\n"); 
		query.append("       ,TO_CHAR(A.RCV_DT,'HH24:MI:SS') AS RCV_HM" ).append("\n"); 
		query.append("       ,A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD_CD" ).append("\n"); 
		query.append("       ,A.POL_CD" ).append("\n"); 
		query.append("       ,A.POD_CD" ).append("\n"); 
		query.append("       ,A.BL_NO" ).append("\n"); 
		query.append("       ,A.CND_ACK_SUB_CD" ).append("\n"); 
		query.append("       ,A.CND_ACK_RCV_ID" ).append("\n"); 
		query.append("       ,A.CSTMS_RJCT_MSG" ).append("\n"); 
		query.append("       ,C1.ATTR_CTNT2 AS ACK_DESC" ).append("\n"); 
		query.append("       ,C2.ATTR_CTNT2 AS RESULT_DESC" ).append("\n"); 
		query.append("       ,A.CND_ACK_ERR_NOTE_DESC" ).append("\n"); 
		query.append("       ,D.ERR_CD_DESC" ).append("\n"); 
		query.append("       ,D.ERR_TP_CTNT" ).append("\n"); 
		query.append("       ,@[rcv_dt_flg] AS RCV_DT_FLG" ).append("\n"); 
		query.append("       ,A.CNT_CD" ).append("\n"); 
		query.append("       ,A.IO_BND_CD" ).append("\n"); 
		query.append("       ,TO_CHAR(A.RCV_DT,'YYYYMMDDHH24MISS') AS DTL_RCV_DT" ).append("\n"); 
		query.append("       ,A.RCV_SEQ" ).append("\n"); 
		query.append("  FROM  BKG_CSTMS_ADV_RCV_LOG A" ).append("\n"); 
		query.append("       ,BKG_HRD_CDG_CTNT C1" ).append("\n"); 
		query.append("       ,BKG_HRD_CDG_CTNT C2" ).append("\n"); 
		query.append("       ,BKG_CSTMS_ADV_ERR D" ).append("\n"); 
		query.append(" WHERE  A.CNT_CD = 'CA'" ).append("\n"); 
		query.append("   AND  A.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("   AND  C1.HRD_CDG_ID(+) = 'CND_ACK_CODE'" ).append("\n"); 
		query.append("   AND  A.CND_ACK_RCV_ID = C1.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("   AND  C2.HRD_CDG_ID(+) = 'CND_RESULT_CODE'" ).append("\n"); 
		query.append("   AND  A.CND_ACK_SUB_CD = C2.ATTR_CTNT1(+)" ).append("\n"); 
		query.append("   AND  A.CSTMS_RJCT_MSG = D.CSTMS_ERR_CD(+)" ).append("\n"); 
		query.append("   AND  D.CNT_CD(+) = 'CA'" ).append("\n"); 
		query.append("#if (${rcv_msg_tp_id} != '')" ).append("\n"); 
		query.append("   AND  A.RCV_MSG_TP_ID = @[rcv_msg_tp_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("   AND  A.VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("   AND  A.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("   AND  A.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '')" ).append("\n"); 
		query.append("   AND  A.POL_CD = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '')" ).append("\n"); 
		query.append("   AND  A.POD_CD = @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '')" ).append("\n"); 
		query.append("   AND  A.BL_NO = @[bl_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rcv_dt_flg} != '')" ).append("\n"); 
		query.append("   AND  A.RCV_DT BETWEEN TO_DATE(@[s_rcv_dt],'yyyyMMddhh24mi') AND TO_DATE(@[e_rcv_dt],'yyyyMMddhh24mi')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY A.RCV_DT, A.RCV_SEQ" ).append("\n"); 

	}
}