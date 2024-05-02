/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOsearchIFTSAIVslInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.30
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.03.30 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOsearchIFTSAIVslInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * IFTSAI전송을 위한 Vessel 정보를 조회한다.
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOsearchIFTSAIVslInfoRSQL(){
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
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vps_call_ind",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration ").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOsearchIFTSAIVslInfoRSQL").append("\n"); 
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
		query.append("SELECT B.CALL_SGN_NO CALL_SG" ).append("\n"); 
		query.append(", VSL_SLAN_NM LANE_NM" ).append("\n"); 
		query.append(", DECODE(A.EDI_SND_KNT, 1, '9', '62') SEND_CNT" ).append("\n"); 
		query.append(", CLPT_SEQ CALL_SEQ" ).append("\n"); 
		query.append(", VSL_ENG_NM VSL_NM" ).append("\n"); 
		query.append(", REPLACE(REPLACE(NVL(VPS_RMK, ' '), CHR(13)||CHR(10), ' '), CHR(9), ' ') REMARK" ).append("\n"); 
		query.append("FROM    VSK_VSL_PORT_SKD A, MDM_VSL_CNTR B, MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("WHERE   A.VSL_CD        = B.VSL_CD      (+)" ).append("\n"); 
		query.append("AND     A.SLAN_CD       = C.VSL_SLAN_CD (+)" ).append("\n"); 
		query.append("AND     A.VSL_CD        = @[vsl_cd]" ).append("\n"); 
		query.append("AND     A.SKD_VOY_NO    = @[skd_voy_no]" ).append("\n"); 
		query.append("AND     A.SKD_DIR_CD    = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND     A.VPS_PORT_CD   = @[vps_port_cd]" ).append("\n"); 
		query.append("AND     A.CLPT_IND_SEQ  = @[vps_call_ind]" ).append("\n"); 
		query.append("AND     'S'             <> NVL(A.SKD_CNG_STS_CD, ' ')" ).append("\n"); 

	}
}