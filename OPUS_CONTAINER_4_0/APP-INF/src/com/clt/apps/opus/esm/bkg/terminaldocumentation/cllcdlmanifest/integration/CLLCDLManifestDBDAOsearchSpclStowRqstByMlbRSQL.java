/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CLLCDLManifestDBDAOsearchSpclStowRqstByMlbRSQL.java
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

public class CLLCDLManifestDBDAOsearchSpclStowRqstByMlbRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();

	Logger log =Logger.getLogger(this.getClass());

	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;

	/**
	  * <pre>
	  * searchSpclStowRqstByMlb
	  * </pre>
	  */
	public CLLCDLManifestDBDAOsearchSpclStowRqstByMlbRSQL(){
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
		query.append("FileName : CLLCDLManifestDBDAOsearchSpclStowRqstByMlbRSQL").append("\n");
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
		query.append("DECODE(SUM(AB_20), 0, '', SUM(AB_20)) AB_20," ).append("\n");
		query.append("DECODE(SUM(AB_40), 0, '', SUM(AB_40)) AB_40," ).append("\n");
		query.append("DECODE(SUM(AB_40H), 0, '', SUM(AB_40H)) AB_40H," ).append("\n");
		query.append("DECODE(SUM(AB_45), 0, '', SUM(AB_45)) AB_45," ).append("\n");
		query.append("DECODE(SUM(AF_20), 0, '', SUM(AF_20)) AF_20," ).append("\n");
		query.append("DECODE(SUM(AF_40), 0, '', SUM(AF_40)) AF_40," ).append("\n");
		query.append("DECODE(SUM(AF_40H), 0, '', SUM(AF_40H)) AF_40H," ).append("\n");
		query.append("DECODE(SUM(AF_45), 0, '', SUM(AF_45)) AF_45," ).append("\n");
		query.append("DECODE(SUM(AL_20), 0, '', SUM(AL_20)) AL_20," ).append("\n");
		query.append("DECODE(SUM(AL_40), 0, '', SUM(AL_40)) AL_40," ).append("\n");
		query.append("DECODE(SUM(AL_40H), 0, '', SUM(AL_40H)) AL_40H," ).append("\n");
		query.append("DECODE(SUM(AL_45), 0, '', SUM(AL_45)) AL_45," ).append("\n");
		query.append("DECODE(SUM(BC_20), 0, '', SUM(BC_20)) BC_20," ).append("\n");
		query.append("DECODE(SUM(BC_40), 0, '', SUM(BC_40)) BC_40," ).append("\n");
		query.append("DECODE(SUM(BC_40H), 0, '', SUM(BC_40H)) BC_40H," ).append("\n");
		query.append("DECODE(SUM(BC_45), 0, '', SUM(BC_45)) BC_45," ).append("\n");
		query.append("DECODE(SUM(MUPG_20), 0, '', SUM(MUPG_20)) MUPG_20," ).append("\n");
		query.append("DECODE(SUM(MUPG_40), 0, '', SUM(MUPG_40)) MUPG_40," ).append("\n");
		query.append("DECODE(SUM(MUPG_40H), 0, '', SUM(MUPG_40H)) MUPG_40H," ).append("\n");
		query.append("DECODE(SUM(MUPG_45), 0, '', SUM(MUPG_45)) MUPG_45," ).append("\n");
		query.append("DECODE(SUM(OD_20), 0, '', SUM(OD_20)) OD_20," ).append("\n");
		query.append("DECODE(SUM(OD_40), 0, '', SUM(OD_40)) OD_40," ).append("\n");
		query.append("DECODE(SUM(OD_40H), 0, '', SUM(OD_40H)) OD_40H," ).append("\n");
		query.append("DECODE(SUM(OD_45), 0, '', SUM(OD_45)) OD_45," ).append("\n");
		query.append("DECODE(SUM(OBSS_20), 0, '', SUM(OBSS_20)) OBSS_20," ).append("\n");
		query.append("DECODE(SUM(OBSS_40), 0, '', SUM(OBSS_40)) OBSS_40," ).append("\n");
		query.append("DECODE(SUM(OBSS_40H), 0, '', SUM(OBSS_40H)) OBSS_40H," ).append("\n");
		query.append("DECODE(SUM(OBSS_45), 0, '', SUM(OBSS_45)) OBSS_45," ).append("\n");
		query.append("DECODE(SUM(OBSG_20), 0, '', SUM(OBSG_20)) OBSG_20," ).append("\n");
		query.append("DECODE(SUM(OBSG_40), 0, '', SUM(OBSG_40)) OBSG_40," ).append("\n");
		query.append("DECODE(SUM(OBSG_40H), 0, '', SUM(OBSG_40H)) OBSG_40H," ).append("\n");
		query.append("DECODE(SUM(OBSG_45), 0, '', SUM(OBSG_45)) OBSG_45," ).append("\n");
		query.append("DECODE(SUM(ODAB_20), 0, '', SUM(ODAB_20)) ODAB_20," ).append("\n");
		query.append("DECODE(SUM(ODAB_40), 0, '', SUM(ODAB_40)) ODAB_40," ).append("\n");
		query.append("DECODE(SUM(ODAB_40H), 0, '', SUM(ODAB_40H)) ODAB_40H," ).append("\n");
		query.append("DECODE(SUM(ODAB_45), 0, '', SUM(ODAB_45)) ODAB_45" ).append("\n");
		query.append("FROM (" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("NVL(LO.UN_LOC_CD,BV.POD_CD) GUBUN_CD3," ).append("\n");
		query.append("NVL(MAX(DECODE(NVL(BV.POD_CD,' '), 'USSEA', DECODE(BV.SLAN_CD,'PSX',DECODE(DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'ONE','SE1','SEA'),DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'))," ).append("\n");
		query.append("'USOAK', DECODE(BV.SLAN_CD,'PSX','OAK')," ).append("\n");
		query.append("'USLGB', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC')," ).append("\n");
		query.append("'CAVAN', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'')),NVL(LO.UN_LOC_CD,BV.POD_CD)) BLCK_STWG_CD," ).append("\n");
		query.append("DECODE(MAX(DECODE(NVL(BV.POD_CD,' '), 'USSEA', DECODE(BV.SLAN_CD,'PSX',DECODE(DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'ONE','SE1','SEA'),DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'))," ).append("\n");
		query.append("'USOAK', DECODE(BV.SLAN_CD,'PSX','OAK')," ).append("\n");
		query.append("'USLGB', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC')," ).append("\n");
		query.append("'CAVAN', DECODE(SUBSTR(NVL(BK.BLCK_STWG_CD,'LOC'), 3, 1),'1','ONE','2','TWO','3','THR','4','FOR','5','FIV','T','TRS', 'LOC'),'')),'LOC','11','ONE','12','TWO','13','THR','14','FOR','15','FIV', '15.5', 'HOT','16','TRS','17', '18') AA," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) AB_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) AB_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'AB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) AB_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) AB_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AF',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AF',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) AF_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AF',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AF',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) AF_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AF',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'AF',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) AF_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AF',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AF',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) AF_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) AL_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) AL_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'AL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0)) AL_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) AL_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'BC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'BC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) BC_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'BC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'BC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) BC_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'BC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'BC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0)) BC_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'BC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'BC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) BC_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'MUPG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'MUPG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) MUPG_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'MUPG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'MUPG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) MUPG_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'MUPG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'MUPG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0)) MUPG_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'MUPG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'MUPG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) MUPG_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) OD_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) OD_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0))  OD_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) OD_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OBSS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OBSS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) OBSS_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OBSS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OBSS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) OBSS_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OBSS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'OBSS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) OBSS_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OBSS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OBSS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) OBSS_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OBSG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OBSG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) OBSG_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OBSG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OBSG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) OBSG_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OBSG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OBSG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) OBSG_45," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OBSG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'OBSG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0)) OBSG_40H," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'ODAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) ODAB_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'ODAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) ODAB_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'ODAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'ODAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) ODAB_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'ODAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) ODAB_45," ).append("\n");
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
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) AB_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) AB_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'AB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) AB_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) AB_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AF',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AF',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) AF_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AF',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AF',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) AF_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AF',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'AF',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) AF_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AF',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AF',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) AF_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) AL_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) AL_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'AL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0)) AL_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'AL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'AL',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) AL_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'BC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'BC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) BC_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'BC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'BC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) BC_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'BC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'BC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0)) BC_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'BC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'BC',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) BC_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'MUPG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'MUPG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) MUPG_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'MUPG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'MUPG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) MUPG_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'MUPG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'MUPG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0)) MUPG_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'MUPG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'MUPG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) MUPG_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) OD_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) OD_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0))  OD_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OD',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) OD_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OBSS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OBSS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) OBSS_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OBSS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OBSS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) OBSS_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OBSS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'OBSS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) OBSS_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OBSS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OBSS',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) OBSS_45," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OBSG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OBSG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) OBSG_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OBSG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OBSG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) OBSG_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OBSG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'OBSG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) OBSG_45," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'OBSG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'OBSG',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0,  '7', 0, BQ.OP_CNTR_QTY),0)) OBSG_40H," ).append("\n");
		query.append("" ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'ODAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2',BQ.OP_CNTR_QTY,0),0)) ODAB_20," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'ODAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'4',BQ.OP_CNTR_QTY,0),0)) ODAB_40," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'ODAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0),0,'',DECODE(BK.STWG_CD,'ODAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'2', 0, '4', 0, '7', 0,  BQ.OP_CNTR_QTY),0)) ODAB_40H," ).append("\n");
		query.append("DECODE(DECODE(BK.STWG_CD,'ODAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0),0,'',DECODE(BK.STWG_CD,'ODAB',DECODE(SUBSTR(BQ.CNTR_TPSZ_CD,2,1),'7',BQ.OP_CNTR_QTY,0),0)) ODAB_45," ).append("\n");
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
		query.append("" ).append("\n");
		query.append("AND BV.VSL_CD     = @[in_vsl_cd]" ).append("\n");
		query.append("AND BV.SKD_VOY_NO = @[in_skd_voy_no]" ).append("\n");
		query.append("AND BV.SKD_DIR_CD = @[in_skd_dir_cd]" ).append("\n");
		query.append("AND BV.POL_CD     = @[in_pol_cd]" ).append("\n");
		query.append("AND SUBSTR(BV.POL_YD_CD,6,2) like @[in_pol_yd_cd]||'%'" ).append("\n");
		query.append("" ).append("\n");
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
		query.append("DECODE(SUM(AB_20), 0, '', SUM(AB_20)) AB_20," ).append("\n");
		query.append("DECODE(SUM(AB_40), 0, '', SUM(AB_40)) AB_40," ).append("\n");
		query.append("DECODE(SUM(AB_40H), 0, '', SUM(AB_40H)) AB_40H," ).append("\n");
		query.append("DECODE(SUM(AB_45), 0, '', SUM(AB_45)) AB_45," ).append("\n");
		query.append("DECODE(SUM(AF_20), 0, '', SUM(AF_20)) AF_20," ).append("\n");
		query.append("DECODE(SUM(AF_40), 0, '', SUM(AF_40)) AF_40," ).append("\n");
		query.append("DECODE(SUM(AF_40H), 0, '', SUM(AF_40H)) AF_40H," ).append("\n");
		query.append("DECODE(SUM(AF_45), 0, '', SUM(AF_45)) AF_45," ).append("\n");
		query.append("DECODE(SUM(AL_20), 0, '', SUM(AL_20)) AL_20," ).append("\n");
		query.append("DECODE(SUM(AL_40), 0, '', SUM(AL_40)) AL_40," ).append("\n");
		query.append("DECODE(SUM(AL_40H), 0, '', SUM(AL_40H)) AL_40H," ).append("\n");
		query.append("DECODE(SUM(AL_45), 0, '', SUM(AL_45)) AL_45," ).append("\n");
		query.append("DECODE(SUM(BC_20), 0, '', SUM(BC_20)) BC_20," ).append("\n");
		query.append("DECODE(SUM(BC_40), 0, '', SUM(BC_40)) BC_40," ).append("\n");
		query.append("DECODE(SUM(BC_40H), 0, '', SUM(BC_40H)) BC_40H," ).append("\n");
		query.append("DECODE(SUM(BC_45), 0, '', SUM(BC_45)) BC_45," ).append("\n");
		query.append("DECODE(SUM(MUPG_20), 0, '', SUM(MUPG_20)) MUPG_20," ).append("\n");
		query.append("DECODE(SUM(MUPG_40), 0, '', SUM(MUPG_40)) MUPG_40," ).append("\n");
		query.append("DECODE(SUM(MUPG_40H), 0, '', SUM(MUPG_40H)) MUPG_40H," ).append("\n");
		query.append("DECODE(SUM(MUPG_45), 0, '', SUM(MUPG_45)) MUPG_45," ).append("\n");
		query.append("DECODE(SUM(OD_20), 0, '', SUM(OD_20)) OD_20," ).append("\n");
		query.append("DECODE(SUM(OD_40), 0, '', SUM(OD_40)) OD_40," ).append("\n");
		query.append("DECODE(SUM(OD_40H), 0, '', SUM(OD_40H)) OD_40H," ).append("\n");
		query.append("DECODE(SUM(OD_45), 0, '', SUM(OD_45)) OD_45," ).append("\n");
		query.append("DECODE(SUM(OBSS_20), 0, '', SUM(OBSS_20)) OBSS_20," ).append("\n");
		query.append("DECODE(SUM(OBSS_40), 0, '', SUM(OBSS_40)) OBSS_40," ).append("\n");
		query.append("DECODE(SUM(OBSS_40H), 0, '', SUM(OBSS_40H)) OBSS_40H," ).append("\n");
		query.append("DECODE(SUM(OBSS_45), 0, '', SUM(OBSS_45)) OBSS_45," ).append("\n");
		query.append("DECODE(SUM(OBSG_20), 0, '', SUM(OBSG_20)) OBSG_20," ).append("\n");
		query.append("DECODE(SUM(OBSG_40), 0, '', SUM(OBSG_40)) OBSG_40," ).append("\n");
		query.append("DECODE(SUM(OBSG_40H), 0, '', SUM(OBSG_40H)) OBSG_40H," ).append("\n");
		query.append("DECODE(SUM(OBSG_45), 0, '', SUM(OBSG_45)) OBSG_45," ).append("\n");
		query.append("DECODE(SUM(ODAB_20), 0, '', SUM(ODAB_20)) ODAB_20," ).append("\n");
		query.append("DECODE(SUM(ODAB_40), 0, '', SUM(ODAB_40)) ODAB_40," ).append("\n");
		query.append("DECODE(SUM(ODAB_40H), 0, '', SUM(ODAB_40H)) ODAB_40H," ).append("\n");
		query.append("DECODE(SUM(ODAB_45), 0, '', SUM(ODAB_45)) ODAB_45" ).append("\n");
		query.append("FROM (" ).append("\n");
		query.append("SELECT" ).append("\n");
		query.append("NVL(LO.UN_LOC_CD,BV.POD_CD) GUBUN_CD3" ).append("\n");
		query.append(", NVL(CLL.BLCK_STWG_CD,NVL(LO.UN_LOC_CD,BV.POD_CD)) BLCK_STWG_CD" ).append("\n");
		query.append(", DECODE(CLL.BLCK_STWG_CD,'LOC','11','ONE','12','TWO','13','THR','14','FOR','15','FIV','15.5','HOT','16','TRS','17', '18') AA" ).append("\n");
		query.append(", DECODE(CLL.STWG_CD, 'AB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) AB_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) AB_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0,  '7', 0, 1), 0) AB_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) AB_45," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AF', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) AF_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AF', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) AF_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AF', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0,  '7', 0, 1), 0) AF_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AF', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) AF_45," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AL', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) AL_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AL', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) AL_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AL', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0,  1), 0) AL_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AL', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) AL_45," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'BC', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) BC_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'BC', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) BC_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'BC', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0,  1), 0) BC_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'BC', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) BC_45," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'MUPG', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) MUPG_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'MUPG', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) MUPG_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'MUPG', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0,  1), 0) MUPG_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'MUPG', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) MUPG_45," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) OD_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) OD_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0,  1), 0) OD_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) OD_45," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OBSS', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) OBSS_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OBSS', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) OBSS_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OBSS', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0,  1), 0) OBSS_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OBSS', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) OBSS_45," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OBSG', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) OBSG_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OBSG', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) OBSG_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OBSG', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0,  1), 0) OBSG_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OBSG', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) OBSG_45," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'ODAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) ODAB_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'ODAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) ODAB_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'ODAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0,  1), 0) ODAB_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'ODAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) ODAB_45" ).append("\n");
		query.append("" ).append("\n");
		query.append(", VPS.CLPT_SEQ CLPT_SEQ" ).append("\n");
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
		query.append("GROUP BY NVL(LO.UN_LOC_CD,BV.POD_CD), NVL(CLL.BLCK_STWG_CD,NVL(LO.UN_LOC_CD,BV.POD_CD)), CLL.BLCK_STWG_CD, CLL.STWG_CD, BQ.CNTR_TPSZ_CD, BQ.OP_CNTR_QTY, CM.REP_IMDG_LVL_CD, BK.BKG_NO, VPS.CLPT_SEQ,CLL.CNTR_NO" ).append("\n");
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
		query.append(", DECODE(CLL.STWG_CD, 'AB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) AB_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) AB_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0,  '7', 0, 1), 0) AB_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) AB_45," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AF', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) AF_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AF', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) AF_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AF', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0,  '7', 0, 1), 0) AF_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AF', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) AF_45," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AL', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) AL_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AL', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) AL_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AL', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0,  1), 0) AL_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'AL', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) AL_45," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'BC', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) BC_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'BC', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) BC_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'BC', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0,  1), 0) BC_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'BC', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) BC_45," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'MUPG', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) MUPG_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'MUPG', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) MUPG_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'MUPG', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0,  1), 0) MUPG_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'MUPG', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) MUPG_45," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) OD_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) OD_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0,  1), 0) OD_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OD', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) OD_45," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OBSS', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) OBSS_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OBSS', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) OBSS_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OBSS', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0,  1), 0) OBSS_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OBSS', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) OBSS_45," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OBSG', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) OBSG_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OBSG', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) OBSG_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OBSG', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0,  1), 0) OBSG_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'OBSG', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) OBSG_45," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'ODAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 1, 0), 0) ODAB_20," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'ODAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '4', 1, 0), 0) ODAB_40," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'ODAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '2', 0, '4', 0, '7', 0,  1), 0) ODAB_40H," ).append("\n");
		query.append("DECODE(CLL.STWG_CD, 'ODAB', DECODE(SUBSTR(BQ.CNTR_TPSZ_CD, 2, 1), '7', 1, 0), 0) ODAB_45," ).append("\n");
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
		query.append("GROUP BY NVL(LO.UN_LOC_CD,BV.POD_CD), CLL.BLCK_STWG_CD, NVL(CLL.BLCK_STWG_CD,NVL(LO.UN_LOC_CD,BV.POD_CD)), CLL.STWG_CD, BQ.CNTR_TPSZ_CD, BQ.OP_CNTR_QTY, CM.REP_IMDG_LVL_CD, BK.BKG_NO, VPS.CLPT_SEQ,CLL.CNTR_NO" ).append("\n");
		query.append(")" ).append("\n");
		query.append("GROUP BY AA, GUBUN_CD3, BLCK_STWG_CD, CLPT_SEQ" ).append("\n");
		query.append("ORDER BY CLPT_SEQ, AA, GUBUN_CD3" ).append("\n");
		query.append("" ).append("\n");
		query.append("#end" ).append("\n");
		query.append(")" ).append("\n");

	}
}