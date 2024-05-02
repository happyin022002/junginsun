/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : CndManifestListDownloadDBDAOmodifyMfStsCdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.12
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.12 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CndManifestListDownloadDBDAOmodifyMfStsCdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyMfStsCd
	  * </pre>
	  */
	public CndManifestListDownloadDBDAOmodifyMfStsCdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_trsm_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration").append("\n"); 
		query.append("FileName : CndManifestListDownloadDBDAOmodifyMfStsCdUSQL").append("\n"); 
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
		query.append("UPDATE  BKG_CSTMS_ADV_BL A" ).append("\n"); 
		query.append("   SET  UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("       ,UPD_DT = SYSDATE" ).append("\n"); 
		query.append("#if (${mf_sts_cd} != '')  " ).append("\n"); 
		query.append("       ,MF_STS_CD  = @[mf_sts_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cstms_trsm_sts_cd} != '') " ).append("\n"); 
		query.append("       ,CSTMS_MF_TP_CD = CASE WHEN FULL_MTY_CD = 'M' THEN 'E10'" ).append("\n"); 
		query.append("                              WHEN MF_NO > ' ' THEN 'S10'" ).append("\n"); 
		query.append("                              ELSE 'A6A' END" ).append("\n"); 
		query.append("       ,CSTMS_TRSM_STS_CD = CASE WHEN CSTMS_TRSM_STS_CD IS NULL THEN '00'" ).append("\n"); 
		query.append("                                 WHEN MF_STS_CD = 'D' THEN '03'" ).append("\n"); 
		query.append("                                 WHEN CSTMS_TRSM_STS_CD = '03' AND MF_STS_CD = 'A' THEN '00'" ).append("\n"); 
		query.append("                                 WHEN EXISTS(" ).append("\n"); 
		query.append("                                             SELECT 'X' " ).append("\n"); 
		query.append("                                               FROM BKG_CSTMS_ADV_RCV_LOG " ).append("\n"); 
		query.append("                                              WHERE BL_NO  = A.BL_NO" ).append("\n"); 
		query.append("                                                AND CNT_CD = A.CNT_CD" ).append("\n"); 
		query.append("                                                AND CND_ACK_RCV_ID IN ('A', 'E')" ).append("\n"); 
		query.append("                                            ) THEN '04'" ).append("\n"); 
		query.append("                                 ELSE '00' END" ).append("\n"); 
		query.append("       ,MF_SND_DT = DECODE(@[cstms_trsm_sts_cd], '00', TO_DATE(@[upd_dt],'YYYYMMDDHH24MISS'), MF_SND_DT)" ).append("\n"); 
		query.append("       ,AMDT_SND_DT = CASE WHEN @[cstms_trsm_sts_cd] IN('00','03','04') THEN TO_DATE(@[upd_dt],'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                           ELSE AMDT_SND_DT END" ).append("\n"); 
		query.append("       ,CSTMS_ACK_KEY_NO = DECODE(CSTMS_ACK_KEY_NO, NULL, TO_CHAR(SYSDATE,'YMM')||LTRIM(TO_CHAR(BKG_CSTM_EDI_SEQ.NEXTVAL,'000009'),' '), CSTMS_ACK_KEY_NO)" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append(" WHERE  CNT_CD = 'CA'" ).append("\n"); 
		query.append("   AND  BL_NO  = @[bl_no]" ).append("\n"); 

	}
}