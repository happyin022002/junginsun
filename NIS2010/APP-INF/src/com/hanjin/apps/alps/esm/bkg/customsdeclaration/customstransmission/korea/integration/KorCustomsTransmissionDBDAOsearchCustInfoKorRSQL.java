/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KorCustomsTransmissionDBDAOsearchCustInfoKorRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.18
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2010.01.18 박상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author SANGHUN PARK
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class KorCustomsTransmissionDBDAOsearchCustInfoKorRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Customer Information을 조회한다.
	  * </pre>
	  */
	public KorCustomsTransmissionDBDAOsearchCustInfoKorRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trns_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.integration").append("\n"); 
		query.append("FileName : KorCustomsTransmissionDBDAOsearchCustInfoKorRSQL").append("\n"); 
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
		query.append("SELECT NVL(MAX(DECODE(BKG_CUST_TP_CD,'S',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_NM,' '),CHR(13)||CHR(10),' '))),0),0,'N','Y'),'N')),'N') S_NM" ).append("\n"); 
		query.append(", NVL(MAX(DECODE(BKG_CUST_TP_CD,'S',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_ADDR,' '),CHR(13)||CHR(10),' '))),0),0,'N','Y'),'N')),'N') S_ADDR" ).append("\n"); 
		query.append(", NVL(MAX(DECODE(BKG_CUST_TP_CD,'C',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_NM,' '),CHR(13)||CHR(10),' '))),0),0,'N','Y'),'N')),'N') C_NM" ).append("\n"); 
		query.append(", NVL(MAX(DECODE(BKG_CUST_TP_CD,'C',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_ADDR,' '),CHR(13)||CHR(10),' '))),0),0,'N','Y'),'N')),'N') C_ADDR" ).append("\n"); 
		query.append(", NVL(MAX(DECODE(BKG_CUST_TP_CD,'N',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_NM,' '),CHR(13)||CHR(10),' '))),0),0,'N','Y'),'N')),'N') N_NM" ).append("\n"); 
		query.append(", NVL(MAX(DECODE(BKG_CUST_TP_CD,'N',DECODE(NVL(LENGTH(TRIM(REPLACE(NVL(CUST_ADDR,' '),CHR(13)||CHR(10),' '))),0),0,'N','Y'),'N')),'N') N_ADDR" ).append("\n"); 
		query.append(", NVL(SUBSTR(MAX(DECODE(@[io_bnd_cd],'O',DECODE(BKG_CUST_TP_CD,'S',REPLACE(NVL(CUST_NM,' '),CHR(13)||CHR(10),' '),' ')," ).append("\n"); 
		query.append("DECODE(BKG_CUST_TP_CD,'C',REPLACE(NVL(CUST_NM,' '),CHR(13)||CHR(10),' '),' '))),1,35), ' ') CUST_NM" ).append("\n"); 
		query.append("FROM   BKG_CSTMS_KR_CUST" ).append("\n"); 
		query.append("WHERE  BKG_NO = SUBSTR(@[bkg_no],1,13)" ).append("\n"); 
		query.append("AND    CSTMS_DECL_TP_CD = @[cstms_decl_tp_cd]" ).append("\n"); 
		query.append("AND    DMST_PORT_CD = @[port_cd]" ).append("\n"); 
		query.append("AND    TRNS_SEQ = @[trns_seq]" ).append("\n"); 

	}
}