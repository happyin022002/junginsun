/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaCustomsTransmissionDBDAOsearchActDirCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.19
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsTransmissionDBDAOsearchActDirCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 미세관 snd log 테이블에서 mi전송된것중 ACT_FILE_SKD_DIR_CD필드 값을 조회한다.
	  * </pre>
	  */
	public UsaCustomsTransmissionDBDAOsearchActDirCdRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("msg_tp",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsTransmissionDBDAOsearchActDirCdRSQL").append("\n"); 
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
		query.append("SELECT DECODE(ACT_FILE_SKD_DIR_CD, 'E', 'E', SUBSTR(@[vvd],9,1)) AS ACT_FILE_SKD_DIR_CD" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_ADV_SND_LOG" ).append("\n"); 
		query.append(" WHERE CNT_CD      = 'US'" ).append("\n"); 
		query.append("   AND IO_BND_CD   = 'I'" ).append("\n"); 
		query.append("   AND VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("   AND POL_CD      = @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND POD_CD      = @[pod_cd]" ).append("\n"); 
		query.append("   AND TRSM_MSG_TP_ID = @[msg_tp]" ).append("\n"); 
		query.append("   AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("   AND SND_DT = (" ).append("\n"); 
		query.append("        SELECT MAX(SND_DT)" ).append("\n"); 
		query.append("          FROM BKG_CSTMS_ADV_SND_LOG" ).append("\n"); 
		query.append("         WHERE CNT_CD      = 'US'" ).append("\n"); 
		query.append("           AND IO_BND_CD   = 'I'" ).append("\n"); 
		query.append("           AND VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("           AND SKD_VOY_NO  = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("           AND SKD_DIR_CD  = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("       #if (${pol_cd} != '') " ).append("\n"); 
		query.append("           AND POL_CD      = @[pol_cd]" ).append("\n"); 
		query.append("       #end" ).append("\n"); 
		query.append("           AND POD_CD      = @[pod_cd]" ).append("\n"); 
		query.append("           AND TRSM_MSG_TP_ID = @[msg_tp]" ).append("\n"); 
		query.append("           AND DELT_FLG    = 'N'" ).append("\n"); 
		query.append("        )" ).append("\n"); 

	}
}