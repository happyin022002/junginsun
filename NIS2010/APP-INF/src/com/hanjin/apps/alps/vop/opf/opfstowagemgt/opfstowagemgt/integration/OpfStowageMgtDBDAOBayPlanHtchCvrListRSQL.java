/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OpfStowageMgtDBDAOBayPlanHtchCvrListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.31
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.31 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OpfStowageMgtDBDAOBayPlanHtchCvrListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OpfStowageMgtDBDAOBayPlanHtchCvrList
	  * </pre>
	  */
	public OpfStowageMgtDBDAOBayPlanHtchCvrListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bay_idx",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.opfstowagemgt.opfstowagemgt.integration").append("\n"); 
		query.append("FileName : OpfStowageMgtDBDAOBayPlanHtchCvrListRSQL").append("\n"); 
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
		query.append("SELECT   MIN(DECODE(col1,'0'  ,CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN  '0' > col1 THEN  (CASE WHEN (col1 < col2 AND  '0'  <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_0 " ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'1',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN  '1' > col1 THEN  (CASE WHEN (col1 < col2 AND  '1'  <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_1 " ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'2',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN  '2' > col1 THEN  (CASE WHEN (col1 < col2 AND  '2'  <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_2 " ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'3',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN  '3' > col1 THEN  (CASE WHEN (col1 < col2 AND  '3'  <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_3 " ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'4',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN  '4' > col1 THEN  (CASE WHEN (col1 < col2 AND  '4'  <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_4 " ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'5',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN  '5' > col1 THEN  (CASE WHEN (col1 < col2 AND  '5'  <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_5 " ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'6',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN  '6' > col1 THEN  (CASE WHEN (col1 < col2 AND  '6'  <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_6 " ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'7',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN  '7' > col1 THEN  (CASE WHEN (col1 < col2 AND  '7'  <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_7 " ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'8',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN  '8' > col1 THEN  (CASE WHEN (col1 < col2 AND  '8'  <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_8 " ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'9',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN  '9' > col1 THEN  (CASE WHEN (col1 < col2 AND  '9'  <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_9 " ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'10',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '10' > col1 THEN  (CASE WHEN (col1 < col2 AND '10' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_10" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'11',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '11' > col1 THEN  (CASE WHEN (col1 < col2 AND '11' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_11" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'12',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '12' > col1 THEN  (CASE WHEN (col1 < col2 AND '12' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_12" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'13',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '13' > col1 THEN  (CASE WHEN (col1 < col2 AND '13' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_13" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'14',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '14' > col1 THEN  (CASE WHEN (col1 < col2 AND '14' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_14" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'15',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '15' > col1 THEN  (CASE WHEN (col1 < col2 AND '15' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_15" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'16',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '16' > col1 THEN  (CASE WHEN (col1 < col2 AND '16' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_16" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'17',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '17' > col1 THEN  (CASE WHEN (col1 < col2 AND '17' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_17" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'18',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '18' > col1 THEN  (CASE WHEN (col1 < col2 AND '18' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_18" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'19',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '19' > col1 THEN (CASE WHEN (col1 < col2 AND '19' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_19" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'20',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '20' > col1 THEN (CASE WHEN (col1 < col2 AND '20' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_20" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'21',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '21' > col1 THEN (CASE WHEN (col1 < col2 AND '21' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_21" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'22',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '22' > col1 THEN (CASE WHEN (col1 < col2 AND '22' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_22" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'23',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '23' > col1 THEN (CASE WHEN (col1 < col2 AND '23' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_23" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'24',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '24' > col1 THEN (CASE WHEN (col1 < col2 AND '24' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_24" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'25',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '25' > col1 THEN (CASE WHEN (col1 < col2 AND '25' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_25" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'26',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '26' > col1 THEN (CASE WHEN (col1 < col2 AND '26' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_26" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'27',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '27' > col1 THEN (CASE WHEN (col1 < col2 AND '27' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_27" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'28',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '28' > col1 THEN (CASE WHEN (col1 < col2 AND '28' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_28" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'29',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '29' > col1 THEN (CASE WHEN (col1 < col2 AND '29' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_29" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'30',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '30' > col1 THEN (CASE WHEN (col1 < col2 AND '30' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_30" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'31',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '31' > col1 THEN (CASE WHEN (col1 < col2 AND '31' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_31" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'32',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '32' > col1 THEN (CASE WHEN (col1 < col2 AND '32' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_32" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'33',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '33' > col1 THEN (CASE WHEN (col1 < col2 AND '33' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_33" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'34',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '34' > col1 THEN (CASE WHEN (col1 < col2 AND '34' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_34" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'35',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '35' > col1 THEN (CASE WHEN (col1 < col2 AND '35' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_35" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'36',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '36' > col1 THEN (CASE WHEN (col1 < col2 AND '36' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_36" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'37',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '37' > col1 THEN (CASE WHEN (col1 < col2 AND '37' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_37" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'38',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '38' > col1 THEN (CASE WHEN (col1 < col2 AND '38' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_38" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'39',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '39' > col1 THEN (CASE WHEN (col1 < col2 AND '39' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_39" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'40',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '40' > col1 THEN (CASE WHEN (col1 < col2 AND '40' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_40" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'41',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '41' > col1 THEN (CASE WHEN (col1 < col2 AND '41' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_41" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'42',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '42' > col1 THEN (CASE WHEN (col1 < col2 AND '42' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_42" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'43',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '43' > col1 THEN (CASE WHEN (col1 < col2 AND '43' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_43" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'44',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '44' > col1 THEN (CASE WHEN (col1 < col2 AND '44' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_44" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'45',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '45' > col1 THEN (CASE WHEN (col1 < col2 AND '45' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_45" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'46',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '46' > col1 THEN (CASE WHEN (col1 < col2 AND '46' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_46" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'47',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '47' > col1 THEN (CASE WHEN (col1 < col2 AND '47' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_47" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'48',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '48' > col1 THEN (CASE WHEN (col1 < col2 AND '48' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_48" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'49',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '49' > col1 THEN (CASE WHEN (col1 < col2 AND '49' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_49" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'50',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '50' > col1 THEN (CASE WHEN (col1 < col2 AND '50' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_50" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'51',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '51' > col1 THEN (CASE WHEN (col1 < col2 AND '51' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_51" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'52',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '52' > col1 THEN (CASE WHEN (col1 < col2 AND '52' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_52" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'53',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '53' > col1 THEN (CASE WHEN (col1 < col2 AND '53' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_53" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'54',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '54' > col1 THEN (CASE WHEN (col1 < col2 AND '54' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_54" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'55',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '55' > col1 THEN (CASE WHEN (col1 < col2 AND '55' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_55" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'56',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '56' > col1 THEN (CASE WHEN (col1 < col2 AND '56' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_56" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'57',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '57' > col1 THEN (CASE WHEN (col1 < col2 AND '57' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_57" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'58',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '58' > col1 THEN (CASE WHEN (col1 < col2 AND '58' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_58" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'59',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '59' > col1 THEN (CASE WHEN (col1 < col2 AND '59' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_59" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'60',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '60' > col1 THEN (CASE WHEN (col1 < col2 AND '60' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_60" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'61',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '61' > col1 THEN (CASE WHEN (col1 < col2 AND '61' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_61" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'62',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '62' > col1 THEN (CASE WHEN (col1 < col2 AND '62' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_62" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'63',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '63' > col1 THEN (CASE WHEN (col1 < col2 AND '63' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_63" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'64',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '64' > col1 THEN (CASE WHEN (col1 < col2 AND '64' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_64" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'65',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '65' > col1 THEN (CASE WHEN (col1 < col2 AND '65' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_65" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'66',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '66' > col1 THEN (CASE WHEN (col1 < col2 AND '66' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_66" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'67',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '67' > col1 THEN (CASE WHEN (col1 < col2 AND '67' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_67" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'68',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '68' > col1 THEN (CASE WHEN (col1 < col2 AND '68' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_68" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'69',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '69' > col1 THEN (CASE WHEN (col1 < col2 AND '69' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_69" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'70',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '70' > col1 THEN (CASE WHEN (col1 < col2 AND '70' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_70" ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'71',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '71' > col1 THEN (CASE WHEN (col1 < col2 AND '71' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_71                                                                                                                         " ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'72',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '72' > col1 THEN (CASE WHEN (col1 < col2 AND '72' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_72                                                                                                                         " ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'73',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '73' > col1 THEN (CASE WHEN (col1 < col2 AND '73' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_73                                                                                                                         " ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'74',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '74' > col1 THEN (CASE WHEN (col1 < col2 AND '74' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_74                                                                                                                         " ).append("\n"); 
		query.append("       , MIN(DECODE(col1,'75',CASE WHEN col1 < col2 THEN 'O' ELSE 'X' END,CASE WHEN '75' > col1 THEN (CASE WHEN (col1 < col2 AND '75' <= col2) THEN 'O' ELSE 'X' END) ELSE 'X' END)) AS HTCH_CVR_75                                                                                                                         " ).append("\n"); 
		query.append("from (select  LEAST(uppr_st_cell_psn, lowr_st_cell_psn) col1 , GREATEST(uppr_end_cell_psn, lowr_end_cell_psn)  col2" ).append("\n"); 
		query.append("       from tpl_vsl_stwg_htchcvr" ).append("\n"); 
		query.append("      where vsl_cd = @[vsl_cd]" ).append("\n"); 
		query.append("      and  bay_idx = @[bay_idx]" ).append("\n"); 
		query.append("  )" ).append("\n"); 

	}
}