/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : KorManifestListDBDAOSearchSendCheckKorRSQL.java
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

public class KorManifestListDBDAOSearchSendCheckKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 seq로 조회된 VVD Info에서 Send여부를 check한다.
	  * </pre>
	  */
	public KorManifestListDBDAOSearchSendCheckKorRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("createdtype",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kv_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_tml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_tml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_mrn_chk_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOSearchSendCheckKorRSQL").append("\n"); 
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
		query.append("SELECT DECODE(MF_SND_DT,NULL,'N','Y') MF_SND_DT" ).append("\n"); 
		query.append("  FROM BKG_CSTMS_KR_VVD_SMRY" ).append("\n"); 
		query.append(" WHERE MRN_NO = @[new_mrn_no]" ).append("\n"); 
		query.append("   AND MRN_CHK_NO = @[new_mrn_chk_no]" ).append("\n"); 
		query.append("   AND VSL_CD = SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("   AND SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("   AND SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("   AND OB_DECL_TP_CD = @[createdtype]" ).append("\n"); 
		query.append("   AND VVD_SEQ = @[kv_seq]" ).append("\n"); 
		query.append("   AND DECODE(@[in_bound],'I',DECODE(LENGTH(@[pod_tml]),7,PORT_TML_CD,' '),DECODE(LENGTH(@[pol_tml]),7,PORT_TML_CD,' ')) = DECODE(@[in_bound],'I',DECODE(LENGTH(@[pod_tml]),7,@[pod_tml],' '),DECODE(LENGTH(@[pol_tml]),7,@[pol_tml],' '))" ).append("\n"); 

	}
}