/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorManifestListDBDAOsearchCustCorrInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.18 박상훈
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

public class KorManifestListDBDAOsearchCustCorrInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer 정보를 조회한다.
	  * </pre>
	  */
	public KorManifestListDBDAOsearchCustCorrInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_decl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.integration").append("\n"); 
		query.append("FileName : KorManifestListDBDAOsearchCustCorrInfoRSQL").append("\n"); 
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
		query.append("SELECT BKG_NO," ).append("\n"); 
		query.append("CSTMS_DECL_TP_CD," ).append("\n"); 
		query.append("TRNS_SEQ," ).append("\n"); 
		query.append("MAX(DECODE(BKG_CUST_TP_CD, 'S', CNT_CD, '')) S_CUST_CNT_CD," ).append("\n"); 
		query.append("MAX(DECODE(BKG_CUST_TP_CD, 'S', CUST_SEQ, '')) S_CUST_SEQ," ).append("\n"); 
		query.append("MAX(DECODE(BKG_CUST_TP_CD, 'S', CUST_NM, '')) S_CUST_NM," ).append("\n"); 
		query.append("MAX(DECODE(BKG_CUST_TP_CD, 'S', NVL(RTRIM(CUST_ADDR),'.'), '')) S_CUST_ADDR," ).append("\n"); 
		query.append("MAX(DECODE(BKG_CUST_TP_CD, 'C', CNT_CD, '')) C_CUST_CNT_CD," ).append("\n"); 
		query.append("MAX(DECODE(BKG_CUST_TP_CD, 'C', CUST_SEQ, '')) C_CUST_SEQ," ).append("\n"); 
		query.append("MAX(DECODE(BKG_CUST_TP_CD, 'C', CUST_NM, '')) C_CUST_NM," ).append("\n"); 
		query.append("MAX(DECODE(BKG_CUST_TP_CD, 'C', CUST_ADDR, '')) C_CUST_ADDR," ).append("\n"); 
		query.append("MAX(DECODE(BKG_CUST_TP_CD, 'N', CNT_CD, '')) N_CUST_CNT_CD," ).append("\n"); 
		query.append("MAX(DECODE(BKG_CUST_TP_CD, 'N', CUST_SEQ, '')) N_CUST_SEQ," ).append("\n"); 
		query.append("MAX(DECODE(BKG_CUST_TP_CD, 'N', CUST_NM, '')) N_CUST_NM," ).append("\n"); 
		query.append("MAX(DECODE(BKG_CUST_TP_CD, 'N', CUST_ADDR, '')) N_CUST_ADDR" ).append("\n"); 
		query.append("FROM BKG_CSTMS_KR_CUST" ).append("\n"); 
		query.append("WHERE BKG_NO           =   @[bkg_no]" ).append("\n"); 
		query.append("AND DMST_PORT_CD     =   @[port_cd]" ).append("\n"); 
		query.append("AND CSTMS_DECL_TP_CD =   @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("AND TRNS_SEQ     =   (SELECT MAX(TRNS_SEQ)" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_KR_BL" ).append("\n"); 
		query.append("WHERE  BKG_NO      	  = @[bkg_no]" ).append("\n"); 
		query.append("AND    CSTMS_DECL_TP_CD  = @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("AND    DMST_PORT_CD      = @[port_cd])" ).append("\n"); 
		query.append("GROUP BY BKG_NO, CSTMS_DECL_TP_CD, TRNS_SEQ" ).append("\n"); 

	}
}