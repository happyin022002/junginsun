/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOsearchMrnNoKorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.30
*@LastModifier : 
*@LastVersion : 1.0
* 2012.05.30 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOsearchMrnNoKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 한국세관의 VVD Table로 Download된 상태를 조회한다.
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOsearchMrnNoKorRSQL(){
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
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("in_type",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_tml2",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOsearchMrnNoKorRSQL").append("\n"); 
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
		query.append("VVD.MRN_CHK_NO MRN_CHK_NO," ).append("\n"); 
		query.append("VVD.KV_SEQ VVD_SEQ," ).append("\n"); 
		query.append("VVD.ETA_ETD ETA_DT," ).append("\n"); 
		query.append("VVD.ETD ETD_DT," ).append("\n"); 
		query.append("VVD.PORT_CD PORT_CD" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("SELECT  MRN_NO," ).append("\n"); 
		query.append("MRN_CHK_NO," ).append("\n"); 
		query.append("NVL(VVD_SEQ,0) KV_SEQ," ).append("\n"); 
		query.append("DECODE(@[io_bnd_cd],'I',TO_CHAR(ETA_DT,'YYYY-MM-DD'),TO_CHAR(ETD_DT,'YYYY-MM-DD')) ETA_ETD," ).append("\n"); 
		query.append("TO_CHAR(ETD_DT,'YYYY-MM-DD HH24:MI:SS') ETD," ).append("\n"); 
		query.append("PORT_CD" ).append("\n"); 
		query.append("FROM    BKG_CSTMS_KR_VVD_SMRY" ).append("\n"); 
		query.append("WHERE   VSL_CD        = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND     SKD_VOY_NO    = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND     SKD_DIR_CD    = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND     PORT_CD       = DECODE(@[io_bnd_cd], 'O', @[pol_cd], @[pod_cd])" ).append("\n"); 
		query.append("AND     IO_BND_CD     = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND     ((@[in_type] IN ('A','B','C','D','M') AND OB_DECL_TP_CD IN ('A','B','C','D','M')) OR (@[in_type] = 'N' AND OB_DECL_TP_CD = @[in_type]))" ).append("\n"); 
		query.append("AND     ((@[io_bnd_cd] = 'O' AND nvl(PORT_TML_CD,' ') like '%')" ).append("\n"); 
		query.append("OR DECODE(LENGTH(@[pod_tml2]),7,PORT_TML_CD,' ') = DECODE(LENGTH(@[pod_tml2]),7,@[pod_tml2],' '))" ).append("\n"); 
		query.append("ORDER BY VVD_SEQ DESC) VVD" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}