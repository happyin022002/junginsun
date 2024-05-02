/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HongKongCustomsTransmissionDBDAOsearchVslGeneralRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2010.02.19 김승민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.hongkong.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author KIM SEUNG MIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HongKongCustomsTransmissionDBDAOsearchVslGeneralRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 홍콩세관 신고용 Manifest Vessel General 정보를 조회한다.
	  * </pre>
	  */
	public HongKongCustomsTransmissionDBDAOsearchVslGeneralRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amend_vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.hongkong.integration").append("\n"); 
		query.append("FileName : HongKongCustomsTransmissionDBDAOsearchVslGeneralRSQL").append("\n"); 
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
		query.append("SELECT (NVL(A.VSL_CD,'')||NVL(A.SKD_VOY_NO,'')||NVL(A.SKD_DIR_CD,'')) vvd_number," ).append("\n"); 
		query.append("	   (NVL(DECODE(@[pol_cd],'CNHKG','HKHKG',@[pol_cd]),'')) pol_cd," ).append("\n"); 
		query.append("	   (NVL(DECODE(@[pod_cd],'CNHKG','HKHKG',@[pod_cd]),'')) pod_cd," ).append("\n"); 
		query.append("       (NVL(D.CALL_SGN_NO,'')) vsl_callsign," ).append("\n"); 
		query.append("       (NVL(D.LLOYD_NO,'')) vsl_lloydcode," ).append("\n"); 
		query.append("       (NVL(D.VSL_ENG_NM,'')) vsl_fullname," ).append("\n"); 
		query.append("       (NVL(TO_CHAR(A.VPS_ETA_DT,'YYYYMMDDHH24MI'),'')) eta_dt, " ).append("\n"); 
		query.append("       (NVL(TO_CHAR(A.VPS_ETD_DT,'YYYYMMDDHH24MI'),'')) etd_dt," ).append("\n"); 
		query.append("	   (NVL(TO_CHAR(A.VPS_ETA_DT,'YYYYMMDDHH24MI'),'')) ata_dt," ).append("\n"); 
		query.append("	    '' declaration," ).append("\n"); 
		query.append("	   (@[amend_vvd]) amend_vvd,  -- searchSentVsl()에서 구한 값" ).append("\n"); 
		query.append("       DECODE(@[pol_cd],null,'',NVL(C.VPS_PORT_CD,'')) nextport," ).append("\n"); 
		query.append("       DECODE(@[pol_cd],null,'',NVL(TO_CHAR(C.VPS_ETA_DT,'YYYYMMDDHH24MI'),'')) nextport_eta," ).append("\n"); 
		query.append("       DECODE(@[pol_cd],null,NVL(B.VPS_PORT_CD,''),'') prevport," ).append("\n"); 
		query.append("       DECODE(@[pol_cd],null,NVL(TO_CHAR(B.VPS_ETD_DT,'YYYYMMDDHH24MI'),''),'') prevport_etd" ).append("\n"); 
		query.append("         FROM  VSK_VSL_PORT_SKD A, VSK_VSL_PORT_SKD B, VSK_VSL_PORT_SKD C, MDM_VSL_CNTR D" ).append("\n"); 
		query.append("         WHERE A.VSL_CD		    = @[vsl_cd]" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO		= @[skd_voy_no]" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD		= @[skd_dir_cd]" ).append("\n"); 
		query.append("           AND A.CLPT_IND_SEQ	= '1'" ).append("\n"); 
		query.append("           AND A.VPS_PORT_CD	= NVL(@[pol_cd],@[pod_cd])" ).append("\n"); 
		query.append("           AND (A.CLPT_SEQ - 1) = B.CLPT_SEQ(+)" ).append("\n"); 
		query.append("           AND A.VSL_CD		    = B.VSL_CD(+)" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO		= B.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD		= B.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND B.CLPT_IND_SEQ(+)	= '1'" ).append("\n"); 
		query.append("           AND (A.CLPT_SEQ + 1) 	= C.CLPT_SEQ(+)" ).append("\n"); 
		query.append("           AND A.VSL_CD		    = C.VSL_CD(+)" ).append("\n"); 
		query.append("           AND A.SKD_VOY_NO		= C.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("           AND A.SKD_DIR_CD		= C.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("           AND C.CLPT_IND_SEQ(+)	= '1'" ).append("\n"); 
		query.append("           AND A.VSL_CD		= D.VSL_CD" ).append("\n"); 

	}
}