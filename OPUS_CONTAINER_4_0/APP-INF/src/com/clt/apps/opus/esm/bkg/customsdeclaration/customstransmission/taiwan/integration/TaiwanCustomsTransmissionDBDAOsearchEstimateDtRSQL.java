/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TaiwanCustomsTransmissionDBDAOsearchEstimateDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TaiwanCustomsTransmissionDBDAOsearchEstimateDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 대만세관 신고용 Manifest Estimated Date 정보를 조회한다.
	  * </pre>
	  */
	public TaiwanCustomsTransmissionDBDAOsearchEstimateDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.taiwan.integration").append("\n"); 
		query.append("FileName : TaiwanCustomsTransmissionDBDAOsearchEstimateDtRSQL").append("\n"); 
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
		query.append("SELECT NVL(TO_CHAR(VPS_ETA_DT,'RRMMDD'),' ') AS ETA_DT," ).append("\n"); 
		query.append("       NVL(TO_CHAR(VPS_ETD_DT,'RRMMDD'),' ') AS ETD_DT," ).append("\n"); 
		query.append("       DECODE(@[io_bnd_cd], 'I', IB_CSSM_VOY_NO, 'O', OB_CSSM_VOY_NO, ' ') AS CON_VVD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("  FROM VSK_VSL_PORT_SKD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = @[skd_voy_no]" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = @[skd_dir_cd]" ).append("\n"); 
		query.append("   AND CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("   AND VPS_PORT_CD = NVL(@[pol_cd], @[pod_cd])" ).append("\n"); 

	}
}