/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorManifestListDBDAOSearchOBTransTypeChgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.02.19 박상훈
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

public class KorManifestListDBDAOSearchOBTransTypeChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * --WHF/CTT Exception Check(Outbound)
	  * --T/S로 인한 WHF/CTT 면제시 kcd_tp을 'R'로 바꿔준다
	  * --BRH_WHF_IND = 'X' 하나만 check해도 ok
	  * </pre>
	  */
	public KorManifestListDBDAOSearchOBTransTypeChgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("kt_port",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOSearchOBTransTypeChgRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT KR.CSTMS_DECL_TP_CD TRANS_TYPE" ).append("\n"); 
		query.append(", DECODE(RATE.BKG_RT_WHF_EXPT_CD,'X','R') TRANS_TYPE_CHG" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_KR_BL KR, BKG_RATE RATE" ).append("\n"); 
		query.append("WHERE  KR.BKG_NO = RATE.BKG_NO(+)" ).append("\n"); 
		query.append("AND    KR.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    KR.CSTMS_DECL_TP_CD IN ('E','R')" ).append("\n"); 
		query.append("AND    KR.DMST_PORT_CD = @[kt_port]" ).append("\n"); 
		query.append("AND    KR.TRNS_SEQ = @[kt_seq]" ).append("\n"); 

	}
}