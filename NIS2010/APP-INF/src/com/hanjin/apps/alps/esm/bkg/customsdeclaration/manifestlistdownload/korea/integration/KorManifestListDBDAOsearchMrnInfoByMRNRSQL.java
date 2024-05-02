/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorManifestListDBDAOsearchMrnInfoByMRNRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.07.03 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorManifestListDBDAOsearchMrnInfoByMRNRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MRN_NO로 조회
	  * </pre>
	  */
	public KorManifestListDBDAOsearchMrnInfoByMRNRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_mrn_mode",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_mrn_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT MRN_NO" ).append("\n"); 
		query.append(", MRN_CHK_NO" ).append("\n"); 
		query.append(", VSL_CD||SKD_VOY_NO||SKD_DIR_CD VVD" ).append("\n"); 
		query.append(", PORT_CD" ).append("\n"); 
		query.append(", IO_BND_CD" ).append("\n"); 
		query.append(", TO_CHAR(SND_DT, 'YY/MM/DD hh24:mi') SND_DT" ).append("\n"); 
		query.append(", TO_CHAR(RSLT_ACK_DT, 'YY/MM/DD hh24:mi') RSLT_DT" ).append("\n"); 
		query.append(", TRSM_MSG_TP_ID RSLT" ).append("\n"); 
		query.append(", ERR_MSG" ).append("\n"); 
		query.append(", CEIL(SYSDATE - NVL(EDI_SND_DT, SYSDATE)) SEND_IND" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_MF_REF_NO" ).append("\n"); 
		query.append("WHERE MRN_NO = @[in_mrn_no]" ).append("\n"); 
		query.append("AND IO_BND_CD = @[in_mrn_mode]" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration ").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchMrnInfoByMRNRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}