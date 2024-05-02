/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOSearchMrnNoKorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOSearchMrnNoKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 한국세관의 VVD Table로 Download된 상태를 조회한다.
	  * </pre>
	  */
	public KorManifestListDBDAOSearchMrnNoKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_tmnl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_bound",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod_tmnl",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pod",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sel_type",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOSearchMrnNoKorRSQL").append("\n"); 
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
		query.append("SELECT  VVD.MRN_NO MRN_NO," ).append("\n"); 
		query.append("        VVD.MRN_CHK_NO MRN_CHK_NO," ).append("\n"); 
		query.append("        VVD.KV_SEQ VVD_SEQ," ).append("\n"); 
		query.append("        VVD.ETA_ETD ETA_ETD," ).append("\n"); 
		query.append("        VVD.ETD ETD_DT" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("        SELECT  MRN_NO," ).append("\n"); 
		query.append("                MRN_CHK_NO," ).append("\n"); 
		query.append("                NVL(VVD_SEQ,0) KV_SEQ," ).append("\n"); 
		query.append("                DECODE(@[in_bound],'I',TO_CHAR(ETA_DT,'YYYY-MM-DD'),TO_CHAR(ETD_DT,'YYYY-MM-DD')) ETA_ETD," ).append("\n"); 
		query.append("                TO_CHAR(ETD_DT,'YYYY-MM-DD HH24:MI:SS') ETD" ).append("\n"); 
		query.append("        FROM    BKG_CSTMS_KR_VVD_SMRY" ).append("\n"); 
		query.append("        WHERE   VSL_CD        = SUBSTR(@[in_vvd],1,4)" ).append("\n"); 
		query.append("        AND     SKD_VOY_NO    = SUBSTR(@[in_vvd],5,4)" ).append("\n"); 
		query.append("        AND     SKD_DIR_CD    = SUBSTR(@[in_vvd],9,1)" ).append("\n"); 
		query.append("        AND     PORT_CD       = DECODE(@[in_bound], 'O', @[in_pol], @[in_pod])" ).append("\n"); 
		query.append("        AND     IO_BND_CD     = @[in_bound]" ).append("\n"); 
		query.append("        AND     OB_DECL_TP_CD  =  @[sel_type]" ).append("\n"); 
		query.append("		AND     (" ).append("\n"); 
		query.append("                   (" ).append("\n"); 
		query.append("				   		(LENGTH(@[in_pol_tmnl]) = 7 and PORT_TML_CD = @[in_pol_tmnl])					" ).append("\n"); 
		query.append("						 OR" ).append("\n"); 
		query.append("				        (LENGTH(@[in_pol_tmnl]) <> 7 and length(nvl(PORT_TML_CD, 'aa')) <> 7)" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                 OR (" ).append("\n"); 
		query.append("				   		(LENGTH(@[in_pod_tmnl]) = 7 and PORT_TML_CD = @[in_pod_tmnl])					" ).append("\n"); 
		query.append("						 OR" ).append("\n"); 
		query.append("				        (LENGTH(@[in_pod_tmnl]) <> 7 and length(nvl(PORT_TML_CD, 'aa')) <> 7)" ).append("\n"); 
		query.append("                     )" ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("        ORDER BY VVD_SEQ DESC) VVD" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}