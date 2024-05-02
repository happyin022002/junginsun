/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDAOSearchCNTRInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.10.22 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDAOSearchCNTRInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [searchCNTRInfo]
	  * </pre>
	  */
	public KorManifestListDAOSearchCNTRInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("a_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDAOSearchCNTRInfoRSQL").append("\n"); 
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
		query.append("SELECT NVL(CNTR.CNTR_NO,' ')       CNTR_NO" ).append("\n"); 
		query.append(", NVL(CNTR.CNTR_TPSZ_CD,' ')  CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", NVL(SEAL.CNTR_SEAL_NO,' ')  CNTR_SEAL_NO" ).append("\n"); 
		query.append(", NVL(CNTR.PCK_QTY,0)         PCK_QTY" ).append("\n"); 
		query.append(", NVL(CNTR.PCK_TP_CD,' ')     PCK_TP_CD" ).append("\n"); 
		query.append(", NVL(CNTR.CNTR_WGT,0)        CNTR_WGT" ).append("\n"); 
		query.append(", NVL(CNTR.WGT_UT_CD,' ')     WGT_UT_CD" ).append("\n"); 
		query.append(", NVL(CNTR.MEAS_QTY,0)        MEAS_QTY" ).append("\n"); 
		query.append(", NVL(CNTR.MEAS_UT_CD,' ')    MEAS_UT_CD" ).append("\n"); 
		query.append(", NVL(QTY.OP_CNTR_QTY,0)      OP_CNTR_QTY" ).append("\n"); 
		query.append(", NVL(CNTR.CNTR_VOL_QTY,0)    CNTR_VOL_QTY" ).append("\n"); 
		query.append("FROM BKG_CONTAINER     CNTR" ).append("\n"); 
		query.append(", BKG_QUANTITY      QTY" ).append("\n"); 
		query.append(", BKG_CNTR_SEAL_NO  SEAL" ).append("\n"); 
		query.append("WHERE CNTR.BKG_NO       = @[a_bkg_no]" ).append("\n"); 
		query.append("AND CNTR.BKG_NO       = SEAL.BKG_NO(+)" ).append("\n"); 
		query.append("AND CNTR.CNTR_NO      = SEAL.CNTR_NO(+)" ).append("\n"); 
		query.append("AND CNTR.BKG_NO       = QTY.BKG_NO(+)" ).append("\n"); 
		query.append("AND CNTR.CNTR_TPSZ_CD = QTY.CNTR_TPSZ_CD(+)" ).append("\n"); 
		query.append("ORDER BY NVL(CNTR.CNTR_NO,' ')" ).append("\n"); 

	}
}