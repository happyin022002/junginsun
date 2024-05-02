/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : IMDGCodeMgtDBDAOAutoCreationRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2010.02.19 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dohyoung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class IMDGCodeMgtDBDAOAutoCreationRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * AutoCreation
	  * </pre>
	  */
	public IMDGCodeMgtDBDAOAutoCreationRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_21",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_41",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_43",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_42",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_23",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_22",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_51",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_16",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_cd4",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_52",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_cd3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_62",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_61",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_22",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_23",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_21",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_23",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_62",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_61",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_62",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_21",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_22",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_21",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_22",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_23",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_61",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_61",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_62",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_16",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_52",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_51",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_41",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_42",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_43",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_52",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_16",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_51",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_cd2",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_subs_rsk_lbl_cd1",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_12",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_11",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_14",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_3",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_13",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_16",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_8",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_15",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_9",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("com_fm_7",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_41",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_41",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_42",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("away_fm_43",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_43",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lon_fm_42",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_51",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("seq_fm_52",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.integration").append("\n"); 
		query.append("FileName : IMDGCodeMgtDBDAOAutoCreationRSQL").append("\n"); 
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
		query.append("SELECT DECODE(@[away_fm_11],'A','1',DECODE(@[seq_fm_11],'S','2',DECODE(@[com_fm_11],'C','3',DECODE(@[lon_fm_11],'L','4',DECODE(MAX(ON1),'-1','X','0','*',MAX(ON1)))))) CLSS_CD_11," ).append("\n"); 
		query.append("       DECODE(@[away_fm_12],'A','1',DECODE(@[seq_fm_12],'S','2',DECODE(@[com_fm_12],'C','3',DECODE(@[lon_fm_12],'L','4',DECODE(MAX(ON2),'-1','X','0','*',MAX(ON2)))))) CLSS_CD_12," ).append("\n"); 
		query.append("       DECODE(@[away_fm_15],'A','1',DECODE(@[seq_fm_15],'S','2',DECODE(@[com_fm_15],'C','3',DECODE(@[lon_fm_15],'L','4',DECODE(MAX(ON5),'-1','X','0','*',MAX(ON5)))))) CLSS_CD_15," ).append("\n"); 
		query.append("       DECODE(@[away_fm_13],'A','1',DECODE(@[seq_fm_13],'S','2',DECODE(@[com_fm_13],'C','3',DECODE(@[lon_fm_13],'L','4',DECODE(MAX(ON3),'-1','X','0','*',MAX(ON3)))))) CLSS_CD_13," ).append("\n"); 
		query.append("       DECODE(@[away_fm_16],'A','1',DECODE(@[seq_fm_16],'S','2',DECODE(@[com_fm_16],'C','3',DECODE(@[lon_fm_16],'L','4',DECODE(MAX(ON6),'-1','X','0','*',MAX(ON6)))))) CLSS_CD_16," ).append("\n"); 
		query.append("       DECODE(@[away_fm_14],'A','1',DECODE(@[seq_fm_14],'S','2',DECODE(@[com_fm_14],'C','3',DECODE(@[lon_fm_14],'L','4',DECODE(MAX(ON4),'-1','X','0','*',MAX(ON4)))))) CLSS_CD_14," ).append("\n"); 
		query.append("       DECODE(@[away_fm_21],'A','1',DECODE(@[seq_fm_21],'S','2',DECODE(@[com_fm_21],'C','3',DECODE(@[lon_fm_21],'L','4',DECODE(MAX(TW1),'-1','X','0','*',MAX(TW1)))))) CLSS_CD_21," ).append("\n"); 
		query.append("       DECODE(@[away_fm_22],'A','1',DECODE(@[seq_fm_22],'S','2',DECODE(@[com_fm_22],'C','3',DECODE(@[lon_fm_22],'L','4',DECODE(MAX(TW2),'-1','X','0','*',MAX(TW2)))))) CLSS_CD_22," ).append("\n"); 
		query.append("       DECODE(@[away_fm_23],'A','1',DECODE(@[seq_fm_23],'S','2',DECODE(@[com_fm_23],'C','3',DECODE(@[lon_fm_23],'L','4',DECODE(MAX(TW3),'-1','X','0','*',MAX(TW3)))))) CLSS_CD_23," ).append("\n"); 
		query.append("       DECODE(@[away_fm_3] ,'A','1',DECODE(@[seq_fm_3] ,'S','2',DECODE(@[com_fm_3], 'C','3',DECODE(@[lon_fm_3], 'L','4',DECODE(MAX(TH),'-1', 'X','0','*',MAX(TH))))))  CLSS_CD_3," ).append("\n"); 
		query.append("       DECODE(@[away_fm_41],'A','1',DECODE(@[seq_fm_41],'S','2',DECODE(@[com_fm_41],'C','3',DECODE(@[lon_fm_41],'L','4',DECODE(MAX(FO1),'-1','X','0','*',MAX(FO1)))))) CLSS_CD_41," ).append("\n"); 
		query.append("       DECODE(@[away_fm_42],'A','1',DECODE(@[seq_fm_42],'S','2',DECODE(@[com_fm_42],'C','3',DECODE(@[lon_fm_42],'L','4',DECODE(MAX(FO2),'-1','X','0','*',MAX(FO2)))))) CLSS_CD_42," ).append("\n"); 
		query.append("       DECODE(@[away_fm_43],'A','1',DECODE(@[seq_fm_43],'S','2',DECODE(@[com_fm_43],'C','3',DECODE(@[lon_fm_43],'L','4',DECODE(MAX(FO3),'-1','X','0','*',MAX(FO3)))))) CLSS_CD_43," ).append("\n"); 
		query.append("       DECODE(@[away_fm_51],'A','1',DECODE(@[seq_fm_51],'S','2',DECODE(@[com_fm_51],'C','3',DECODE(@[lon_fm_51],'L','4',DECODE(MAX(FI1),'-1','X','0','*',MAX(FI1)))))) CLSS_CD_51," ).append("\n"); 
		query.append("       DECODE(@[away_fm_52],'A','1',DECODE(@[seq_fm_52],'S','2',DECODE(@[com_fm_52],'C','3',DECODE(@[lon_fm_52],'L','4',DECODE(MAX(FI2),'-1','X','0','*',MAX(FI2)))))) CLSS_CD_52," ).append("\n"); 
		query.append("       DECODE(@[away_fm_61],'A','1',DECODE(@[seq_fm_61],'S','2',DECODE(@[com_fm_61],'C','3',DECODE(@[lon_fm_61],'L','4',DECODE(MAX(SI1),'-1','X','0','*',MAX(SI1)))))) CLSS_CD_61," ).append("\n"); 
		query.append("       DECODE(@[away_fm_62],'A','1',DECODE(@[seq_fm_62],'S','2',DECODE(@[com_fm_62],'C','3',DECODE(@[lon_fm_62],'L','4',DECODE(MAX(SI2),'-1','X','0','*',MAX(SI2)))))) CLSS_CD_62," ).append("\n"); 
		query.append("       DECODE(@[away_fm_7] ,'A','1',DECODE(@[seq_fm_7] ,'S','2',DECODE(@[com_fm_7], 'C','3',DECODE(@[lon_fm_7], 'L','4',DECODE(MAX(SE), '-1','X','0','*',MAX(SE))))))  CLSS_CD_7," ).append("\n"); 
		query.append("       DECODE(@[away_fm_8] ,'A','1',DECODE(@[seq_fm_8] ,'S','2',DECODE(@[com_fm_8], 'C','3',DECODE(@[lon_fm_8], 'L','4',DECODE(MAX(EI), '-1','X','0','*',MAX(EI))))))  CLSS_CD_8," ).append("\n"); 
		query.append("       DECODE(@[away_fm_9] ,'A','1',DECODE(@[seq_fm_9] ,'S','2',DECODE(@[com_fm_9], 'C','3',DECODE(@[lon_fm_9], 'L','4',DECODE(MAX(NI), '-1','X','0','*',MAX(NI))))))  CLSS_CD_9" ).append("\n"); 
		query.append("FROM   (" ).append("\n"); 
		query.append("		SELECT 	MAX(DECODE(COL_IMDG_CLSS_CD,'1.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON2, " ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.5',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON5," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.3',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON3," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.6',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON6," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.4',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON4," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'2.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TW1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'2.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TW2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'2.3',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TW3," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'3',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TH," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'4.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FO1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'4.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FO2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'4.3',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FO3," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'5.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FI1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'5.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FI2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'6.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) SI1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'6.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) SI2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'7',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) SE," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'8',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) EI," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'9',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) NI" ).append("\n"); 
		query.append("		FROM   SCG_IMDG_CLSS_SEGR" ).append("\n"); 
		query.append("		WHERE  ROW_IMDG_CLSS_CD = @[imdg_clss_cd]--:class_cd" ).append("\n"); 
		query.append("        UNION ALL" ).append("\n"); 
		query.append("		SELECT	MAX(DECODE(COL_IMDG_CLSS_CD,'1.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON2, " ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.5',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON5," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.3',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON3," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.6',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON6," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.4',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON4," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'2.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TW1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'2.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TW2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'2.3',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TW3," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'3',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TH," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'4.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FO1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'4.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FO2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'4.3',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FO3," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'5.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FI1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'5.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FI2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'6.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) SI1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'6.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) SI2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'7',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) SE," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'8',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) EI," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'9',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) NI" ).append("\n"); 
		query.append("         FROM   SCG_IMDG_CLSS_SEGR" ).append("\n"); 
		query.append("         WHERE  ROW_IMDG_CLSS_CD = @[imdg_subs_rsk_lbl_cd1]--:srl1" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT	MAX(DECODE(COL_IMDG_CLSS_CD,'1.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON2, " ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.5',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON5," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.3',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON3," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.6',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON6," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.4',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON4," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'2.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TW1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'2.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TW2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'2.3',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TW3," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'3',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TH," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'4.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FO1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'4.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FO2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'4.3',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FO3," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'5.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FI1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'5.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FI2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'6.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) SI1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'6.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) SI2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'7',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) SE," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'8',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) EI," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'9',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) NI" ).append("\n"); 
		query.append("         FROM   SCG_IMDG_CLSS_SEGR" ).append("\n"); 
		query.append("         WHERE  ROW_IMDG_CLSS_CD = @[imdg_subs_rsk_lbl_cd2]--:srl2" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT MAX(DECODE(COL_IMDG_CLSS_CD,'1.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON2, " ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.5',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON5," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.3',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON3," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.6',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON6," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.4',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON4," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'2.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TW1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'2.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TW2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'2.3',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TW3," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'3',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TH," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'4.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FO1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'4.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FO2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'4.3',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FO3," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'5.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FI1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'5.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FI2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'6.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) SI1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'6.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) SI2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'7',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) SE," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'8',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) EI," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'9',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) NI" ).append("\n"); 
		query.append("         FROM   SCG_IMDG_CLSS_SEGR" ).append("\n"); 
		query.append("         WHERE  ROW_IMDG_CLSS_CD = @[imdg_subs_rsk_lbl_cd3]--:srl3" ).append("\n"); 
		query.append("         UNION ALL" ).append("\n"); 
		query.append("         SELECT MAX(DECODE(COL_IMDG_CLSS_CD,'1.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON2, " ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.5',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON5," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.3',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON3," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.6',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON6," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'1.4',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) ON4," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'2.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TW1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'2.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TW2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'2.3',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TW3," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'3',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) TH," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'4.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FO1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'4.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FO2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'4.3',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FO3," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'5.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FI1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'5.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) FI2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'6.1',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) SI1," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'6.2',DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) SI2," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'7',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) SE," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'8',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) EI," ).append("\n"); 
		query.append("                MAX(DECODE(COL_IMDG_CLSS_CD,'9',  DECODE(IMDG_SEGR_CD,'X','-1','*','0',IMDG_SEGR_CD),NULL)) NI" ).append("\n"); 
		query.append("         FROM   SCG_IMDG_CLSS_SEGR" ).append("\n"); 
		query.append("         WHERE  ROW_IMDG_CLSS_CD = @[imdg_subs_rsk_lbl_cd4]--:srl4" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}