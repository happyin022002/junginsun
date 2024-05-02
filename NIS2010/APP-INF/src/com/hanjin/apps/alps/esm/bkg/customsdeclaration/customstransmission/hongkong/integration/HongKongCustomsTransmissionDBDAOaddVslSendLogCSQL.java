/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HongKongCustomsTransmissionDBDAOaddVslSendLogCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.12.07 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SEUN GMIN KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class HongKongCustomsTransmissionDBDAOaddVslSendLogCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 홍콩세관에 Manifest 신고한 VSL 전송 History를 생성한다.
	  * </pre>
	  */
	public HongKongCustomsTransmissionDBDAOaddVslSendLogCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("user_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mf_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.integration").append("\n"); 
		query.append("FileName : HongKongCustomsTransmissionDBDAOaddVslSendLogCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CSTMS_HKG_SND_LOG" ).append("\n"); 
		query.append("(MF_SND_DT, CRE_DT, UPD_DT," ).append("\n"); 
		query.append("VSL_CD,  SKD_VOY_NO, SKD_DIR_CD," ).append("\n"); 
		query.append("MF_SND_SEQ, POL_CD, POD_CD," ).append("\n"); 
		query.append("CRE_USR_ID, UPD_USR_ID, SNDR_OFC_CD )" ).append("\n"); 
		query.append("VALUES(TO_DATE(@[mf_snd_dt],'YYYY-MM-DD HH24:MI:SS')," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("sysdate," ).append("\n"); 
		query.append("@[vsl_cd], @[skd_voy_no], @[skd_dir_cd]," ).append("\n"); 
		query.append("(SELECT	NVL(MAX(MF_SND_SEQ),0)" ).append("\n"); 
		query.append("FROM	BKG_CSTMS_HKG_SND_LOG" ).append("\n"); 
		query.append("WHERE	VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("AND	SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("AND	SKD_DIR_CD    = @[skd_dir_cd]) +1, @[pol_cd], @[pod_cd]," ).append("\n"); 
		query.append("@[user_id], @[user_id],@[ofc_cd] )" ).append("\n"); 

	}
}