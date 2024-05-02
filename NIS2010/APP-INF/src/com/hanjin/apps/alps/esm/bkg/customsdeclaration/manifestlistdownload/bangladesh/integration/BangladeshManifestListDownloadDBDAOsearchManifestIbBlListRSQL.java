/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : BangladeshManifestListDownloadDBDAOsearchManifestIbBlListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.18 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BangladeshManifestListDownloadDBDAOsearchManifestIbBlListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 방글라데시 Manifest Inbound B/L List
	  * searchManifestIbBlList
	  * </pre>
	  */
	public BangladeshManifestListDownloadDBDAOsearchManifestIbBlListRSQL(){
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
		params.put("bkg_cgo_tp_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_code",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_yd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_yd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.integration").append("\n"); 
		query.append("FileName : BangladeshManifestListDownloadDBDAOsearchManifestIbBlListRSQL").append("\n"); 
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
		query.append("SELECT DECODE(LENGTH(DENSE_RANK() OVER (PARTITION BY  BK.DEL_CD ORDER BY BK.BL_NO)),'1'," ).append("\n"); 
		query.append("       DECODE(BK.DEL_CD,'BDCGP','SML'||TRIM(TO_CHAR(DENSE_RANK() OVER (PARTITION BY  BK.DEL_CD ORDER BY BK.BL_NO),'00'))," ).append("\n"); 
		query.append("                        'BDDAC','SMLICD'||TRIM(TO_CHAR(DENSE_RANK() OVER (PARTITION BY  BK.DEL_CD ORDER BY BK.BL_NO),'00')))," ).append("\n"); 
		query.append("                                                                                                              '2'," ).append("\n"); 
		query.append("       DECODE(BK.DEL_CD,'BDCGP','SML'||TRIM(TO_CHAR(DENSE_RANK() OVER (PARTITION BY  BK.DEL_CD ORDER BY BK.BL_NO),'00'))," ).append("\n"); 
		query.append("                        'BDDAC','SMLICD'||TRIM(TO_CHAR(DENSE_RANK() OVER (PARTITION BY  BK.DEL_CD ORDER BY BK.BL_NO),'000')))," ).append("\n"); 
		query.append("                                                                                                              '3'," ).append("\n"); 
		query.append("       DECODE(BK.DEL_CD,'BDCGP','SML'||TRIM(TO_CHAR(DENSE_RANK() OVER (PARTITION BY  BK.DEL_CD ORDER BY BK.BL_NO),'0000'))," ).append("\n"); 
		query.append("                        'BDDAC','RSLICD'||TRIM(TO_CHAR(DENSE_RANK() OVER (PARTITION BY  BK.DEL_CD ORDER BY BK.BL_NO),'0000')))," ).append("\n"); 
		query.append("                                                                                                              '4'," ).append("\n"); 
		query.append("       DECODE(BK.DEL_CD,'BDCGP','SML'||TRIM(TO_CHAR(DENSE_RANK() OVER (PARTITION BY  BK.DEL_CD ORDER BY BK.BL_NO),'00'))," ).append("\n"); 
		query.append("                        'BDDAC','SMLICD'||TRIM(TO_CHAR(DENSE_RANK() OVER (PARTITION BY  BK.DEL_CD ORDER BY BK.BL_NO),'00')))," ).append("\n"); 
		query.append("       DECODE(BK.DEL_CD,'BDCGP','SML'||TRIM(TO_CHAR(DENSE_RANK() OVER (PARTITION BY  BK.DEL_CD ORDER BY BK.BL_NO),'00'))," ).append("\n"); 
		query.append("                        'BDDAC','SMLICD'||TRIM(TO_CHAR(DENSE_RANK() OVER (PARTITION BY  BK.DEL_CD ORDER BY BK.BL_NO),'00')))) LINE_NO," ).append("\n"); 
		query.append("       'SMLM'||BK.BL_NO BL_NO," ).append("\n"); 
		query.append("       NVL(CNTR.PCK_QTY,0) QTY," ).append("\n"); 
		query.append("       TRIM(DECODE(CNTR.PCK_TP_CD,'PK','PKG','CT','CTN',NULL,' ', PK.PCK_NM)) DESCRIPTION, " ).append("\n"); 
		query.append("       TRIM(REPLACE(REPLACE(SUBSTR(REPLACE(REPLACE(REPLACE(NVL(BL_MARK.MK_DESC,''),CHR(13)||CHR(10),' '),'',' '),CHR(9),''),1,700),CHR(34),''),' ',' ')) MARKS," ).append("\n"); 
		query.append("       TRIM(REPLACE(REPLACE(SUBSTR(REPLACE(REPLACE(REPLACE(NVL(DES.CSTMS_DESC,''),CHR(13)||CHR(10),' '),'',' '),CHR(9),''),1,200),CHR(34),''),' ',' ')) GOODS_DESC," ).append("\n"); 
		query.append("       '' GOODS_DATE," ).append("\n"); 
		query.append("       '' CONS_LICE," ).append("\n"); 
		query.append("       REPLACE(SUBSTR(REPLACE(REPLACE(REPLACE(NVL(C.CUST_NM,' '),CHR(13)||CHR(10),' '),'',' '),CHR(9),' '),1,150)||SUBSTR(REPLACE(REPLACE(REPLACE(NVL(C.CUST_ADDR,' '),CHR(13)||CHR(10),' '),'',' '),CHR(9),' '),1,100),' ',' ') CONS_NM," ).append("\n"); 
		query.append("       '' NOTY_LICE," ).append("\n"); 
		query.append("       REPLACE(SUBSTR(REPLACE(REPLACE(REPLACE(NVL(N.CUST_NM,' '),CHR(13)||CHR(10),' '),'',' '),CHR(9),' '),1,150)||SUBSTR(REPLACE(REPLACE(REPLACE(NVL(N.CUST_ADDR,' '),CHR(13)||CHR(10),' '),'',' '),CHR(9),' '),1,100),' ',' ') NOTY_NM," ).append("\n"); 
		query.append("       TRIM(TO_CHAR(NVL(CNTR.CNTR_WGT,0),'999999999.99'))||' '||CNTR.WGT_UT_CD BL_GROSS_WGT," ).append("\n"); 
		query.append("       '' BL_NET_WGT," ).append("\n"); 
		query.append("       NVL(CNTR.CNTR_NO,'') CNTR_NO," ).append("\n"); 
		query.append("       NVL(SEAL.CNTR_SEAL_NO,'') SEAL," ).append("\n"); 
		query.append("       DECODE(SUBSTR(CNTR.CNTR_TPSZ_CD,2,1),'2','20','4','40','5','40','7','45','8','48','9','48',' ') CNTR_SIZE, " ).append("\n"); 
		query.append("       DECODE(SUBSTR(CNTR.CNTR_TPSZ_CD,1,1),'D','DRY','F','FLAT','O','OPEN','P','PLATFORM','R','REEFER','T','TANK','Z','OTHER','Q','DEAD','S','SLIDING','A','ADJUST',' ') CNTR_TYPE, " ).append("\n"); 
		query.append("       DECODE(SUBSTR(CNTR.CNTR_TPSZ_CD,2,1),'2','8.6','4','8.6','5','9.6','9','8.6',' ') HEIGHT," ).append("\n"); 
		query.append("       TRIM(to_char(NVL(CNTR.CNTR_WGT,'0'), '99999999.99')) CNTR_GROSS_WGT, " ).append("\n"); 
		query.append("       ( SELECT DECODE(NVL(S.TARE_WGT, 0), 0" ).append("\n"); 
		query.append("              ,     DECODE(NVL(MDM.CNTR_TPSZ_TARE_WGT, 0), 0" ).append("\n"); 
		query.append("              ,         DECODE(M.CNTR_TPSZ_CD, 'T2', 3600, 'T4', 5200, 0) " ).append("\n"); 
		query.append("              ,            MDM.CNTR_TPSZ_TARE_WGT)" ).append("\n"); 
		query.append("              ,         S.TARE_WGT  ) TARE_WGT" ).append("\n"); 
		query.append("           FROM MST_CONTAINER M, MST_CNTR_SPEC S, MDM_CNTR_TP_SZ MDM" ).append("\n"); 
		query.append("          WHERE M.CNTR_NO           =   CNTR.CNTR_NO" ).append("\n"); 
		query.append("            AND M.CNTR_SPEC_NO      =   S.CNTR_SPEC_NO(+)" ).append("\n"); 
		query.append("            AND M.CNTR_TPSZ_CD      =   MDM.CNTR_TPSZ_CD ) CNTR_TARE_WGT," ).append("\n"); 
		query.append("       'FCL' STATUS," ).append("\n"); 
		query.append("       '' IMCO," ).append("\n"); 
		query.append("       '' UN," ).append("\n"); 
		query.append("       '' VAT," ).append("\n"); 
		query.append("       '' CMDT_CD," ).append("\n"); 
		query.append("       '' OFF_DOCK," ).append("\n"); 
		query.append("       'N' PERISH_CD," ).append("\n"); 
		query.append("       '' REMARKS," ).append("\n"); 
		query.append("	   BK.BL_NO ORG_BL_NO," ).append("\n"); 
		query.append("       CNTR.CNTR_TPSZ_CD CNTR_TZ," ).append("\n"); 
		query.append("       BK.POL_CD POL_CD," ).append("\n"); 
		query.append("       BK.POD_CD POD_CD," ).append("\n"); 
		query.append("       TRIM(to_char(NVL(CNTR.CNTR_WGT,'0'), '99999999.99')) CNTR_WGT," ).append("\n"); 
		query.append("       CNTR.WGT_UT_CD CNTR_UT_CD," ).append("\n"); 
		query.append("       NVL(BK.BKG_CGO_TP_CD,'F') BKG_CGO_TP_CD," ).append("\n"); 
		query.append("       VSL.VSL_ENG_NM VSL_NM," ).append("\n"); 
		query.append("	   DECODE(SUBSTR(VVD.SKD_VOY_NO,1,2), '00', SUBSTR(VVD.SKD_VOY_NO,2,3), VVD.SKD_VOY_NO) VOY_NO," ).append("\n"); 
		query.append("       'A' TEMP," ).append("\n"); 
		query.append("	   @[vvd] VVD," ).append("\n"); 
		query.append("	   '' AS CRE_USR_ID," ).append("\n"); 
		query.append("	   '' AS UPD_USR_ID," ).append("\n"); 
		query.append("		(" ).append("\n"); 
		query.append("			SELECT CNTR_TPSZ_ISO_CD" ).append("\n"); 
		query.append("	 		FROM MDM_CNTR_TP_SZ" ).append("\n"); 
		query.append("			WHERE CNTR_TPSZ_CD = CNTR.CNTR_TPSZ_CD" ).append("\n"); 
		query.append("		) CNTR_TPSZ_ISO_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM  BKG_BOOKING BK, BKG_CONTAINER CNTR, BKG_BL_DOC DES," ).append("\n"); 
		query.append("      BKG_CUSTOMER C, BKG_CUSTOMER N, BKG_VVD VVD, " ).append("\n"); 
		query.append("      BKG_BL_MK_DESC BL_MARK, MDM_VSL_CNTR VSL, MDM_PCK_TP PK " ).append("\n"); 
		query.append("      ," ).append("\n"); 
		query.append("      (" ).append("\n"); 
		query.append("        SELECT BKG_NO, CNTR_NO, SUBSTR(MAX(SYS_CONNECT_BY_PATH (CNTR_SEAL_NO,',')),2) AS CNTR_SEAL_NO" ).append("\n"); 
		query.append("        FROM  (" ).append("\n"); 
		query.append("            SELECT  SEAL.BKG_NO, SEAL.CNTR_NO, SEAL.CNTR_SEAL_NO, SEAL.CNTR_SEAL_SEQ RNUM" ).append("\n"); 
		query.append("            FROM    BKG_VVD VVD, BKG_CONTAINER CNTR, BKG_CNTR_SEAL_NO SEAL" ).append("\n"); 
		query.append("            WHERE   1=1" ).append("\n"); 
		query.append("            AND     VVD.VSL_CD      = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("            AND     VVD.SKD_VOY_NO	= SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("            AND     VVD.SKD_DIR_CD	= SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("            AND     VVD.POD_CD    	= @[pod_code]" ).append("\n"); 
		query.append("		#if (${pod_yd} != '') " ).append("\n"); 
		query.append("			AND     SUBSTR(VVD.POD_YD_CD,6,2) 	like @[pod_yd]||'%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${pol_code} != '') " ).append("\n"); 
		query.append("           	AND     VVD.POL_CD      			like @[pol_code]||'%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("		#if (${pol_yd} != '') " ).append("\n"); 
		query.append("			AND     SUBSTR(VVD.POL_YD_CD,6,2) 	like @[pol_yd]||'%'" ).append("\n"); 
		query.append("		#end" ).append("\n"); 
		query.append("            AND     VVD.BKG_NO    = CNTR.BKG_NO " ).append("\n"); 
		query.append("            AND     CNTR.BKG_NO   = SEAL.BKG_NO" ).append("\n"); 
		query.append("            AND     CNTR.CNTR_NO  = SEAL.CNTR_NO" ).append("\n"); 
		query.append("        )" ).append("\n"); 
		query.append("        GROUP BY BKG_NO, CNTR_NO" ).append("\n"); 
		query.append("        START WITH RNUM = 1" ).append("\n"); 
		query.append("        CONNECT BY PRIOR RNUM = RNUM - 1 AND PRIOR CNTR_NO = CNTR_NO" ).append("\n"); 
		query.append("      )SEAL" ).append("\n"); 
		query.append("WHERE 1=1 " ).append("\n"); 
		query.append("AND  VVD.BKG_NO 	  = BK.BKG_NO " ).append("\n"); 
		query.append("AND  BK.BKG_NO 		  = CNTR.BKG_NO " ).append("\n"); 
		query.append("AND  CNTR.BKG_NO 	  = SEAL.BKG_NO(+)" ).append("\n"); 
		query.append("AND  CNTR.CNTR_NO 	  = SEAL.CNTR_NO(+)" ).append("\n"); 
		query.append("AND  BK.BKG_NO 		  = DES.BKG_NO(+) " ).append("\n"); 
		query.append("AND  BK.BKG_NO 		  = C.BKG_NO " ).append("\n"); 
		query.append("AND  BK.BKG_NO 		  = N.BKG_NO " ).append("\n"); 
		query.append("AND  BK.BKG_NO 		  = BL_MARK.BKG_NO(+) " ).append("\n"); 
		query.append("AND  VVD.VSL_CD 	  = VSL.VSL_CD " ).append("\n"); 
		query.append("AND  C.BKG_CUST_TP_CD ='C' " ).append("\n"); 
		query.append("AND  N.BKG_CUST_TP_CD ='N' " ).append("\n"); 
		query.append("AND  CNTR.PCK_TP_CD   = PK.PCK_CD(+) " ).append("\n"); 
		query.append("AND  BK.BKG_STS_CD NOT IN ( 'X','S' )  " ).append("\n"); 
		query.append("AND  VVD.VSL_CD       = SUBSTR(@[vvd],1,4)" ).append("\n"); 
		query.append("AND  VVD.SKD_VOY_NO   = SUBSTR(@[vvd],5,4)" ).append("\n"); 
		query.append("AND  VVD.SKD_DIR_CD   = SUBSTR(@[vvd],9,1)" ).append("\n"); 
		query.append("AND  VVD.POD_CD 	  = @[pod_code]" ).append("\n"); 
		query.append("#if (${pod_yd} != '') " ).append("\n"); 
		query.append("	AND SUBSTR(VVD.POD_YD_CD,6,2) like @[pod_yd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_code} != '') " ).append("\n"); 
		query.append("    AND VVD.POL_CD      		  like @[pol_code]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_yd} != '') " ).append("\n"); 
		query.append("	AND SUBSTR(VVD.POL_YD_CD,6,2) like @[pol_yd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_no} != '') " ).append("\n"); 
		query.append("	AND BK.BL_NO				  like @[bl_no]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_cgo_tp_code} != 'A') " ).append("\n"); 
		query.append("	AND  DECODE(BK.BKG_CGO_TP_CD,'P','P','F') = @[bkg_cgo_tp_code]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY LINE_NO, BL_NO, CNTR_NO" ).append("\n"); 

	}
}