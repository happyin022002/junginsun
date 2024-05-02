/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchSpclStowRqst3ByMlbRSQL.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.28
*@LastModifier :
*@LastVersion : 1.0
* 2013.08.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author janginho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CLLCDLManifestDBDAOsearchSpclStowRqst3ByMlbRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchSpclStowRqst3ByMlb
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchSpclStowRqst3ByMlbRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("in_pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n");
		query.append("Path : com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.integration").append("\n");
		query.append("FileName : CLLCDLManifestDBDAOsearchSpclStowRqst3ByMlbRSQL").append("\n");
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
		query.append("SELECT *" ).append("\n");
		query.append("FROM (" ).append("\n");
		query.append("" ).append("\n");
		query.append("#if (${in_pgm_no} == 'ESM_BKG_0951')" ).append("\n");
		query.append("/**************************** ESM_BKG_0951에서 조회된 경우  *****************************/" ).append("\n");
		query.append("" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("DECODE(GUBUN_CD3,'USSEA',DECODE(BLCK_STWG_CD,'ONE','USEA1','USSEA'),'CAVAN',DECODE(BLCK_STWG_CD,'ONE','CAVA1','LOC','CAYVR','CAVAN'),GUBUN_CD3) GUBUN_CD3" ).append("\n");
		query.append(",'' GUBUN_CD" ).append("\n");
		query.append(",'' GUBUN_CD2" ).append("\n");
		query.append(",BLCK_STWG_CD," ).append("\n");
		query.append("DECODE(SUM(PCOD_20), 0, '', SUM(PCOD_20)) PCOD_20," ).append("\n");
		query.append("DECODE(SUM(PCOD_40), 0, '', SUM(PCOD_40)) PCOD_40," ).append("\n");
		query.append("DECODE(SUM(PCOD_40H), 0, '', SUM(PCOD_40H)) PCOD_40H," ).append("\n");
		query.append("DECODE(SUM(PCOD_45), 0, '', SUM(PCOD_45)) PCOD_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(SUM(TS_20), 0, '', SUM(TS_20)) TS_20," ).append("\n");
		query.append("DECODE(SUM(TS_40), 0, '', SUM(TS_40)) TS_40," ).append("\n");
		query.append("DECODE(SUM(TS_40H), 0, '', SUM(TS_40H)) TS_40H," ).append("\n");
		query.append("DECODE(SUM(TS_45), 0, '', SUM(TS_45)) TS_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(SUM(TSBC_20), 0, '', SUM(TSBC_20)) TSBC_20," ).append("\n");
		query.append("DECODE(SUM(TSBC_40), 0, '', SUM(TSBC_40)) TSBC_40," ).append("\n");
		query.append("DECODE(SUM(TSBC_40H), 0, '', SUM(TSBC_40H)) TSBC_40H ," ).append("\n");
		query.append("DECODE(SUM(TSBC_45), 0, '', SUM(TSBC_45)) TSBC_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(SUM(UD_20), 0, '', SUM(UD_20)) UD_20," ).append("\n");
		query.append("DECODE(SUM(UD_40), 0, '', SUM(UD_40)) UD_40," ).append("\n");
		query.append("DECODE(SUM(UD_40H), 0, '', SUM(UD_40H)) UD_40H ," ).append("\n");
		query.append("DECODE(SUM(UD_45), 0, '', SUM(UD_45)) UD_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(SUM(UDAB_20), 0, '', SUM(UDAB_20)) UDAB_20," ).append("\n");
		query.append("DECODE(SUM(UDAB_40), 0, '', SUM(UDAB_40)) UDAB_40," ).append("\n");
		query.append("DECODE(SUM(UDAB_40H), 0, '', SUM(UDAB_40H)) UDAB_40H ," ).append("\n");
		query.append("DECODE(SUM(UDAB_45), 0, '', SUM(UDAB_45)) UDAB_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(SUM(UT_20), 0, '', SUM(UT_20)) UT_20," ).append("\n");
		query.append("DECODE(SUM(UT_40), 0, '', SUM(UT_40)) UT_40," ).append("\n");
		query.append("DECODE(SUM(UT_40H), 0, '', SUM(UT_40H)) UT_40H ," ).append("\n");
		query.append("DECODE(SUM(UT_45), 0, '', SUM(UT_45)) UT_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(SUM(UTAB_20), 0, '', SUM(UTAB_20)) UTAB_20," ).append("\n");
		query.append("DECODE(SUM(UTAB_40), 0, '', SUM(UTAB_40)) UTAB_40," ).append("\n");
		query.append("DECODE(SUM(UTAB_40H), 0, '', SUM(UTAB_40H)) UTAB_40H ," ).append("\n");
		query.append("DECODE(SUM(UTAB_45), 0, '', SUM(UTAB_45)) UTAB_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(SUM(UW_20), 0, '', SUM(UW_20)) UW_20," ).append("\n");
		query.append("DECODE(SUM(UW_40), 0, '', SUM(UW_40)) UW_40," ).append("\n");
		query.append("DECODE(SUM(UW_40H), 0, '', SUM(UW_40H)) UW_40H," ).append("\n");
		query.append("DECODE(SUM(UW_45), 0, '', SUM(UW_45)) UW_45" ).append("\n");
		query.append("FROM (" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("NVL(LO.UN_LOC_CD,BV.POD_CD) GUBUN_CD3," ).append("\n");
		query.append("NVL(MAX(DECODE(NVL(BV.POD_CD,' '), 'USSEA', DECODE(BV.SLAN_CD,'PSX',DECODE(DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR', '5','FIV', 'T','TRS', 'LOC'),'ONE','SE1','SEA'),DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'))," ).append("\n");
		query.append("'USOAK', DECODE(BV.SLAN_CD,'PSX','OAK')," ).append("\n");
		query.append("'USLGB', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC')," ).append("\n");
		query.append("'CAVAN', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'')),NVL(LO.UN_LOC_CD,BV.POD_CD)) BLCK_STWG_CD," ).append("\n");
		query.append("DECODE(MAX(DECODE(NVL(BV.POD_CD,' '), 'USSEA', DECODE(BV.SLAN_CD,'PSX',DECODE(DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'ONE','SE1','SEA'),DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'))," ).append("\n");
		query.append("'USOAK', DECODE(BV.SLAN_CD,'PSX','OAK')," ).append("\n");
		query.append("'USLGB', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC')," ).append("\n");
		query.append("'CAVAN', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'')),'LOC','11','ONE','12','TWO','13','THR','14','FOR','15','FIV','15.5','HOT','16','TRS','17', '18') AA," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'PCOD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'PCOD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) PCOD_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'PCOD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'PCOD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0)) PCOD_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'PCOD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'PCOD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) PCOD_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'PCOD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'PCOD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7', BQ.OP_CNTR_QTY,0),0)) PCOD_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'TS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'TS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) TS_20 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'TS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'TS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) TS_40 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'TS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'TS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) TS_40H ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'TS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'TS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) TS_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'TSBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'TSBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) TSBC_20 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'TSBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'TSBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) TSBC_40 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'TSBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'TSBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) TSBC_40H ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'TSBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'TSBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) TSBC_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) UD_20 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) UD_40 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) UD_40H ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) UD_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) UDAB_20 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) UDAB_40 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) UDAB_40H ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) UDAB_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) UT_20 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) UT_40 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'UT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) UT_40H ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) UT_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UTAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UTAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) UTAB_20 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UTAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UTAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) UTAB_40 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UTAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'UTAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) UTAB_40H ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UTAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UTAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) UTAB_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) UW_20 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) UW_40 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'UW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) UW_40H ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) UW_45 ," ).append("\n");
		query.append("VPS.CLPT_SEQ CLPT_SEQ" ).append("\n");
		query.append("FROM BKG_BOOKING BK" ).append("\n");
		query.append(", BKG_VVD BV" ).append("\n");
		query.append(", BKG_QUANTITY BQ" ).append("\n");
		query.append(", VSK_VSL_PORT_SKD VPS" ).append("\n");
		query.append(", MDM_COMMODITY CM" ).append("\n");
		query.append(", MDM_LOCATION LO" ).append("\n");
		query.append("WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n");
		query.append("AND BK.BKG_NO = BQ.BKG_NO" ).append("\n");
		query.append("AND BQ.CNTR_TPSZ_CD NOT IN ('Q2','Q4')" ).append("\n");
		query.append("AND BV.VSL_CD = VPS.VSL_CD" ).append("\n");
		query.append("AND BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n");
		query.append("AND BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n");
		query.append("AND BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n");
		query.append("AND BK.CMDT_CD = CM.CMDT_CD" ).append("\n");
		query.append("AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n");
		query.append("AND NVL(CM.DELT_FLG,'N')='N'" ).append("\n");
		query.append("" ).append("\n");
		query.append("AND BV.VSL_CD     = @[in_vsl_cd]" ).append("\n");
		query.append("AND BV.SKD_VOY_NO = @[in_skd_voy_no]" ).append("\n");
		query.append("AND BV.SKD_DIR_CD = @[in_skd_dir_cd]" ).append("\n");
		query.append("AND BV.POL_CD     = @[in_pol_cd]" ).append("\n");
		query.append("" ).append("\n");
		query.append("AND BK.BKG_STS_CD IN ( 'F','W')" ).append("\n");
		query.append("AND VPS.CLPT_IND_SEQ = '1'" ).append("\n");
		query.append("AND NVL(BK.SPLIT_RSN_CD,' ') <> 'M'" ).append("\n");
		query.append("AND BV.POD_CD = 'USLGB'" ).append("\n");
		query.append("AND DECODE(NVL(BV.POD_CD,' '), 'USSEA', DECODE(BV.SLAN_CD,'PSX',DECODE(DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'ONE','SE1','SEA'),DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'))," ).append("\n");
		query.append("'USOAK', DECODE(BV.SLAN_CD,'PSX','OAK')," ).append("\n");
		query.append("'USLGB', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC')," ).append("\n");
		query.append("'CAVAN', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'') IN ('LOC','ONE','TWO','THR','FOR','FIV','HOT','TRS')" ).append("\n");
		query.append("GROUP BY NVL(LO.UN_LOC_CD,BV.POD_CD), BK.STWG_CD, BQ.CNTR_TPSZ_CD, OP_CNTR_QTY, VPS.CLPT_SEQ, BK.BKG_NO" ).append("\n");
		query.append("" ).append("\n");
		query.append("UNION ALL" ).append("\n");
		query.append("" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("NVL(LO.UN_LOC_CD,BV.POD_CD) GUBUN_CD3," ).append("\n");
		query.append("MAX(DECODE(NVL(BV.POD_CD,' '), 'USSEA', DECODE(BV.SLAN_CD,'PSX',DECODE(DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'ONE','SE1','SEA'),DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'))," ).append("\n");
		query.append("'USOAK', DECODE(BV.SLAN_CD,'PSX','OAK')," ).append("\n");
		query.append("'USLGB', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC')," ).append("\n");
		query.append("'CAVAN', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'')) BLCK_STWG_CD," ).append("\n");
		query.append("DECODE(NVL(LO.UN_LOC_CD,BV.POD_CD)," ).append("\n");
		query.append("'USOAK', '20'," ).append("\n");
		query.append("'USSEA', '30'," ).append("\n");
		query.append("'CAVAN', '40'," ).append("\n");
		query.append("'50') AA," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'PCOD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'PCOD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) PCOD_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'PCOD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'PCOD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4', BQ.OP_CNTR_QTY,0),0)) PCOD_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'PCOD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'PCOD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) PCOD_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'PCOD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'PCOD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7', BQ.OP_CNTR_QTY,0),0)) PCOD_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'TS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'TS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) TS_20 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'TS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'TS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) TS_40 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'TS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'TS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) TS_40H ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'TS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'TS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) TS_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'TSBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'TSBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) TSBC_20 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'TSBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'TSBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) TSBC_40 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'TSBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'TSBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) TSBC_40H ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'TSBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'TSBC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) TSBC_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) UD_20 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) UD_40 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) UD_40H ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) UD_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) UDAB_20 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) UDAB_40 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) UDAB_40H ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UDAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) UDAB_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) UT_20 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) UT_40 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'UT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) UT_40H ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UT',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) UT_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UTAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UTAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) UTAB_20 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UTAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UTAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) UTAB_40 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UTAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'UTAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) UTAB_40H ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UTAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UTAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) UTAB_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) UW_20 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) UW_40 ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'UW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) UW_40H ," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'UW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'UW',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) UW_45 ," ).append("\n");
		query.append("VPS.CLPT_SEQ CLPT_SEQ" ).append("\n");
		query.append("FROM BKG_BOOKING BK" ).append("\n");
		query.append(", BKG_VVD BV" ).append("\n");
		query.append(", BKG_QUANTITY BQ" ).append("\n");
		query.append(", VSK_VSL_PORT_SKD VPS" ).append("\n");
		query.append(", MDM_COMMODITY CM" ).append("\n");
		query.append(", MDM_LOCATION LO" ).append("\n");
		query.append("WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n");
		query.append("AND BK.BKG_NO = BQ.BKG_NO" ).append("\n");
		query.append("AND BQ.CNTR_TPSZ_CD NOT IN ('Q2','Q4')" ).append("\n");
		query.append("AND BV.VSL_CD = VPS.VSL_CD" ).append("\n");
		query.append("AND BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n");
		query.append("AND BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n");
		query.append("AND BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n");
		query.append("AND BK.CMDT_CD = CM.CMDT_CD" ).append("\n");
		query.append("AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n");
		query.append("AND NVL(CM.DELT_FLG,'N')='N'" ).append("\n");
		query.append("" ).append("\n");
		query.append("AND BV.VSL_CD     = @[in_vsl_cd]" ).append("\n");
		query.append("AND BV.SKD_VOY_NO = @[in_skd_voy_no]" ).append("\n");
		query.append("AND BV.SKD_DIR_CD = @[in_skd_dir_cd]" ).append("\n");
		query.append("AND BV.POL_CD     = @[in_pol_cd]" ).append("\n");
		query.append("AND SUBSTR(BV.POL_YD_CD,6,2) like @[in_pol_yd_cd]||'%'" ).append("\n");
		query.append("" ).append("\n");
		query.append("AND BK.BKG_STS_CD IN ( 'F','W')" ).append("\n");
		query.append("AND VPS.CLPT_IND_SEQ = '1'" ).append("\n");
		query.append("AND NVL(BK.SPLIT_RSN_CD,' ') <> 'M'" ).append("\n");
		query.append("AND BV.POD_CD <> 'USLGB'" ).append("\n");
		query.append("GROUP BY NVL(LO.UN_LOC_CD,BV.POD_CD), BK.STWG_CD, BQ.CNTR_TPSZ_CD, OP_CNTR_QTY, VPS.CLPT_SEQ, BK.BKG_NO" ).append("\n");
		query.append(")" ).append("\n");
		query.append("GROUP BY AA, GUBUN_CD3, BLCK_STWG_CD, CLPT_SEQ" ).append("\n");
		query.append("ORDER BY CLPT_SEQ, AA, GUBUN_CD3" ).append("\n");
		query.append("" ).append("\n");
		query.append("#else" ).append("\n");
		query.append("/***************************** 기본 조회 *****************************/" ).append("\n");
		query.append("" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("DECODE(GUBUN_CD3,'USSEA',DECODE(BLCK_STWG_CD,'ONE','USEA1','USSEA'),'CAVAN',DECODE(BLCK_STWG_CD,'ONE','CAVA1','LOC','CAYVR','CAVAN'),GUBUN_CD3) GUBUN_CD3" ).append("\n");
		query.append(",'' GUBUN_CD" ).append("\n");
		query.append(",'' GUBUN_CD2" ).append("\n");
		query.append(",BLCK_STWG_CD," ).append("\n");
		query.append("DECODE(SUM(PCOD_20), 0, '', SUM(PCOD_20)) PCOD_20," ).append("\n");
		query.append("DECODE(SUM(PCOD_40), 0, '', SUM(PCOD_40)) PCOD_40," ).append("\n");
		query.append("DECODE(SUM(PCOD_40H), 0, '', SUM(PCOD_40H)) PCOD_40H," ).append("\n");
		query.append("DECODE(SUM(PCOD_45), 0, '', SUM(PCOD_45)) PCOD_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(SUM(TS_20), 0, '', SUM(TS_20)) TS_20," ).append("\n");
		query.append("DECODE(SUM(TS_40), 0, '', SUM(TS_40)) TS_40," ).append("\n");
		query.append("DECODE(SUM(TS_40H), 0, '', SUM(TS_40H)) TS_40H," ).append("\n");
		query.append("DECODE(SUM(TS_45), 0, '', SUM(TS_45)) TS_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(SUM(TSBC_20), 0, '', SUM(TSBC_20)) TSBC_20," ).append("\n");
		query.append("DECODE(SUM(TSBC_40), 0, '', SUM(TSBC_40)) TSBC_40," ).append("\n");
		query.append("DECODE(SUM(TSBC_40H), 0, '', SUM(TSBC_40H)) TSBC_40H ," ).append("\n");
		query.append("DECODE(SUM(TSBC_45), 0, '', SUM(TSBC_45)) TSBC_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(SUM(UD_20), 0, '', SUM(UD_20)) UD_20," ).append("\n");
		query.append("DECODE(SUM(UD_40), 0, '', SUM(UD_40)) UD_40," ).append("\n");
		query.append("DECODE(SUM(UD_40H), 0, '', SUM(UD_40H)) UD_40H ," ).append("\n");
		query.append("DECODE(SUM(UD_45), 0, '', SUM(UD_45)) UD_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(SUM(UDAB_20), 0, '', SUM(UDAB_20)) UDAB_20," ).append("\n");
		query.append("DECODE(SUM(UDAB_40), 0, '', SUM(UDAB_40)) UDAB_40," ).append("\n");
		query.append("DECODE(SUM(UDAB_40H), 0, '', SUM(UDAB_40H)) UDAB_40H ," ).append("\n");
		query.append("DECODE(SUM(UDAB_45), 0, '', SUM(UDAB_45)) UDAB_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(SUM(UT_20), 0, '', SUM(UT_20)) UT_20," ).append("\n");
		query.append("DECODE(SUM(UT_40), 0, '', SUM(UT_40)) UT_40," ).append("\n");
		query.append("DECODE(SUM(UT_40H), 0, '', SUM(UT_40H)) UT_40H ," ).append("\n");
		query.append("DECODE(SUM(UT_45), 0, '', SUM(UT_45)) UT_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(SUM(UTAB_20), 0, '', SUM(UTAB_20)) UTAB_20," ).append("\n");
		query.append("DECODE(SUM(UTAB_40), 0, '', SUM(UTAB_40)) UTAB_40," ).append("\n");
		query.append("DECODE(SUM(UTAB_40H), 0, '', SUM(UTAB_40H)) UTAB_40H ," ).append("\n");
		query.append("DECODE(SUM(UTAB_45), 0, '', SUM(UTAB_45)) UTAB_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(SUM(UW_20), 0, '', SUM(UW_20)) UW_20," ).append("\n");
		query.append("DECODE(SUM(UW_40), 0, '', SUM(UW_40)) UW_40," ).append("\n");
		query.append("DECODE(SUM(UW_40H), 0, '', SUM(UW_40H)) UW_40H," ).append("\n");
		query.append("DECODE(SUM(UW_45), 0, '', SUM(UW_45)) UW_45" ).append("\n");
		query.append("FROM (" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("NVL(LO.UN_LOC_CD,BV.POD_CD) GUBUN_CD3" ).append("\n");
		query.append(", NVL(CLL.BLCK_STWG_CD,NVL(LO.UN_LOC_CD,BV.POD_CD)) BLCK_STWG_CD" ).append("\n");
		query.append(", DECODE(CLL.BLCK_STWG_CD,'LOC','11','ONE','12','TWO','13','THR','14','FOR','15','FIV','15.5','HOT','16','TRS','17', '18') AA" ).append("\n");
		query.append(", DECODE(CLL.STWG_CD, 'PCOD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) PCOD_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'PCOD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) PCOD_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'PCOD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) PCOD_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'PCOD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) PCOD_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'TS', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) TS_20 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'TS', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) TS_40 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'TS', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) TS_40H ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'TS', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) TS_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'TSBC', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) TSBC_20 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'TSBC', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) TSBC_40 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'TSBC', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) TSBC_40H ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'TSBC', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) TSBC_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) UD_20 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) UD_40 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) UD_40H ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) UD_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UDAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) UDAB_20 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UDAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) UDAB_40 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UDAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) UDAB_40H ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UDAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) UDAB_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UT', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) UT_20 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UT', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) UT_40 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UT', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) UT_40H ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UT', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) UT_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UTAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) UTAB_20 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UTAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) UTAB_40 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UTAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) UTAB_40H ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UTAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) UTAB_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UW', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) UW_20 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UW', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) UW_40 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UW', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) UW_40H ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UW', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) UW_45 ," ).append("\n");
		query.append("VPS.CLPT_SEQ CLPT_SEQ" ).append("\n");
		query.append("FROM BKG_BOOKING BK" ).append("\n");
		query.append(", BKG_VVD BV" ).append("\n");
		query.append(", BKG_QUANTITY BQ" ).append("\n");
		query.append(", VSK_VSL_PORT_SKD VPS" ).append("\n");
		query.append(", MDM_COMMODITY CM" ).append("\n");
		query.append(", MDM_LOCATION LO" ).append("\n");
		query.append(", BKG_CSTMS_TML_KR_CLL CLL" ).append("\n");
		query.append("WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n");
		query.append("AND BK.BKG_NO = BQ.BKG_NO" ).append("\n");
		query.append("AND BQ.CNTR_TPSZ_CD = CLL.CNTR_TPSZ_CD" ).append("\n");
		query.append("AND BQ.CNTR_TPSZ_CD NOT IN ('Q2','Q4')" ).append("\n");
		query.append("AND BV.VSL_CD = VPS.VSL_CD" ).append("\n");
		query.append("AND BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n");
		query.append("AND BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n");
		query.append("AND BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n");
		query.append("AND BK.CMDT_CD = CM.CMDT_CD" ).append("\n");
		query.append("AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n");
		query.append("AND NVL(CM.DELT_FLG,'N')='N'" ).append("\n");
		query.append("AND BV.VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n");
		query.append("AND BV.SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n");
		query.append("AND BV.SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n");
		query.append("AND BV.POL_CD = @[in_pol_cd]" ).append("\n");
		query.append("AND BK.BKG_STS_CD IN ( 'F','W')" ).append("\n");
		query.append("AND VPS.CLPT_IND_SEQ = '1'" ).append("\n");
		query.append("AND NVL(BK.SPLIT_RSN_CD,' ') <> 'M'" ).append("\n");
		query.append("AND CLL.CNTR_LIST_NO = BV.VSL_CD||SUBSTR(BV.SKD_VOY_NO,2,3)||BV.SKD_DIR_CD||SUBSTR(BV.POL_CD,3,3)" ).append("\n");
		query.append("AND CLL.BKG_NO = BK.BKG_NO" ).append("\n");
		query.append("AND BV.POD_CD = 'USLGB'" ).append("\n");
		query.append("AND CLL.BLCK_STWG_CD IN ('LOC','ONE','TWO','THR','FOR','FIV','HOT','TRS')" ).append("\n");
		query.append("GROUP BY NVL(LO.UN_LOC_CD,BV.POD_CD), NVL(CLL.BLCK_STWG_CD,NVL(LO.UN_LOC_CD,BV.POD_CD)), CLL.BLCK_STWG_CD, CLL.STWG_CD, BQ.CNTR_TPSZ_CD, 1, CLL.KR_TML_PRCT_ID, BK.BKG_NO, VPS.CLPT_SEQ,CLL.CNTR_NO" ).append("\n");
		query.append("" ).append("\n");
		query.append("UNION ALL" ).append("\n");
		query.append("" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("NVL(LO.UN_LOC_CD,BV.POD_CD) GUBUN_CD3" ).append("\n");
		query.append(", CLL.BLCK_STWG_CD BLCK_STWG_CD" ).append("\n");
		query.append(", DECODE(NVL(LO.UN_LOC_CD,BV.POD_CD)," ).append("\n");
		query.append("'USOAK', '20'," ).append("\n");
		query.append("'USSEA', '30'," ).append("\n");
		query.append("'CAVAN', '40'," ).append("\n");
		query.append("'50') AA" ).append("\n");
		query.append(", DECODE(CLL.STWG_CD, 'PCOD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) PCOD_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'PCOD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) PCOD_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'PCOD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) PCOD_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'PCOD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) PCOD_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'TS', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) TS_20 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'TS', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) TS_40 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'TS', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) TS_40H ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'TS', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) TS_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'TSBC', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) TSBC_20 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'TSBC', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) TSBC_40 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'TSBC', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) TSBC_40H ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'TSBC', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) TSBC_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) UD_20 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) UD_40 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) UD_40H ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) UD_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UDAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) UDAB_20 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UDAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) UDAB_40 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UDAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) UDAB_40H ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UDAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) UDAB_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UT', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) UT_20 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UT', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) UT_40 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UT', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) UT_40H ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UT', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) UT_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UTAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) UTAB_20 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UTAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) UTAB_40 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UTAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) UTAB_40H ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UTAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) UTAB_45 ," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UW', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) UW_20 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UW', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) UW_40 ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UW', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0, 1), 0) UW_40H ," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'UW', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) UW_45 ," ).append("\n");
		query.append("VPS.CLPT_SEQ CLPT_SEQ" ).append("\n");
		query.append("FROM BKG_BOOKING BK" ).append("\n");
		query.append(", BKG_VVD BV" ).append("\n");
		query.append(", BKG_QUANTITY BQ" ).append("\n");
		query.append(", VSK_VSL_PORT_SKD VPS" ).append("\n");
		query.append(", MDM_COMMODITY CM" ).append("\n");
		query.append(", MDM_LOCATION LO" ).append("\n");
		query.append(", BKG_CSTMS_TML_KR_CLL CLL" ).append("\n");
		query.append("WHERE BK.BKG_NO = BV.BKG_NO" ).append("\n");
		query.append("AND BK.BKG_NO = BQ.BKG_NO" ).append("\n");
		query.append("AND BQ.CNTR_TPSZ_CD = CLL.CNTR_TPSZ_CD" ).append("\n");
		query.append("AND BQ.CNTR_TPSZ_CD NOT IN ('Q2','Q4')" ).append("\n");
		query.append("AND BV.VSL_CD = VPS.VSL_CD" ).append("\n");
		query.append("AND BV.SKD_VOY_NO = VPS.SKD_VOY_NO" ).append("\n");
		query.append("AND BV.SKD_DIR_CD = VPS.SKD_DIR_CD" ).append("\n");
		query.append("AND BV.POD_CD = VPS.VPS_PORT_CD" ).append("\n");
		query.append("AND BK.CMDT_CD = CM.CMDT_CD" ).append("\n");
		query.append("AND VPS.VPS_PORT_CD = LO.LOC_CD" ).append("\n");
		query.append("AND NVL(CM.DELT_FLG,'N')='N'" ).append("\n");
		query.append("AND BV.VSL_CD = SUBSTR(@[in_vvd_cd],1,4)" ).append("\n");
		query.append("AND BV.SKD_VOY_NO = SUBSTR(@[in_vvd_cd],5,4)" ).append("\n");
		query.append("AND BV.SKD_DIR_CD = SUBSTR(@[in_vvd_cd],9,1)" ).append("\n");
		query.append("AND BV.POL_CD = @[in_pol_cd]" ).append("\n");
		query.append("AND SUBSTR(BV.POL_YD_CD,6,2) like @[in_pol_yd_cd]||'%'" ).append("\n");
		query.append("AND BK.BKG_STS_CD IN ( 'F','W')" ).append("\n");
		query.append("AND VPS.CLPT_IND_SEQ = '1'" ).append("\n");
		query.append("AND NVL(BK.SPLIT_RSN_CD,' ') <> 'M'" ).append("\n");
		query.append("AND CLL.CNTR_LIST_NO = BV.VSL_CD||SUBSTR(BV.SKD_VOY_NO,2,3)||BV.SKD_DIR_CD||SUBSTR(BV.POL_CD,3,3)" ).append("\n");
		query.append("AND CLL.BKG_NO = BK.BKG_NO" ).append("\n");
		query.append("AND BV.POD_CD <> 'USLGB'" ).append("\n");
		query.append("GROUP BY NVL(LO.UN_LOC_CD,BV.POD_CD), CLL.BLCK_STWG_CD, NVL(CLL.BLCK_STWG_CD,NVL(LO.UN_LOC_CD,BV.POD_CD)), CLL.STWG_CD, BQ.CNTR_TPSZ_CD, BQ.OP_CNTR_QTY, CLL.KR_TML_PRCT_ID, BK.BKG_NO, VPS.CLPT_SEQ,CLL.CNTR_NO" ).append("\n");
		query.append(")" ).append("\n");
		query.append("GROUP BY AA, GUBUN_CD3, BLCK_STWG_CD, CLPT_SEQ" ).append("\n");
		query.append("ORDER BY CLPT_SEQ, AA, GUBUN_CD3" ).append("\n");
		query.append("#end" ).append("\n");
		query.append(")" ).append("\n");

	}
}